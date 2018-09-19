package io.github.musius.member_service.service;

import io.github.musius.member_service.model.Member;
import io.github.musius.member_service.respository.MemberRepository;
import io.github.musius.member_service.web.api.errors.MemberIdAlreadyUsedProblem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Optional<Member> findMemberById(long id) {
        return memberRepository.findById(id);
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {
        return memberRepository.findById(member.getId())
                .map(found -> memberRepository.save(member))
                .orElseThrow(() -> new MemberIdAlreadyUsedProblem(member.getId()));
    }

    public void deleteMemberById(long id) {
        memberRepository.deleteById(id);
    }

    public Page<Member> getAllMembers(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }
}
