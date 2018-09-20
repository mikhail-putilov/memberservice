package io.github.musius.member_service.web.api;

import io.github.musius.member_service.model.Member;
import io.github.musius.member_service.service.MemberService;
import io.github.musius.member_service.web.api.errors.MemberIdsDoNotMatchProblem;
import io.github.musius.member_service.web.api.errors.NewMemberHasAssignedIdProblem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping
public class MemberEndpoint {
    private final MemberService memberService;

    @Autowired
    public MemberEndpoint(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable("id") Long id) {
        Optional<Member> found = memberService.findMemberById(id);
        return found.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/member")
    public ResponseEntity<Member> createNewMember(@RequestBody Member member) throws URISyntaxException {
        if (member.getId() != null) {
            throw new NewMemberHasAssignedIdProblem(member.getId());
        }
        Member created = memberService.createMember(member);
        return ResponseEntity.created(new URI("/member/" + created.getId()))
                .body(created);
    }

    @PutMapping("/member/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable("id") Long id, @RequestBody Member member) {
        if (!Objects.equals(id, member.getId())) {
            throw new MemberIdsDoNotMatchProblem(id, member.getId());
        }
        Member updated = memberService.updateMember(member);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/member/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable("id") Long id) {
        memberService.deleteMemberById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/member")
    public ResponseEntity<List<Member>> getAllUsers(Pageable pageable) {
        final Page<Member> page = memberService.getAllMembers(pageable);
        return ResponseEntity.ok(page.getContent());
    }
}
