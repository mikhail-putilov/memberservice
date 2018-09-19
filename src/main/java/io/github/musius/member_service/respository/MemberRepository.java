package io.github.musius.member_service.respository;

import io.github.musius.member_service.model.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemberRepository {
    private Map<Long, Member> store = new HashMap<>();
    private long sequence = 1;

    public Optional<Member> findMemberById(long id) {
        return Optional.ofNullable(store.getOrDefault(id, null));
    }

    public Member createMember(Member member) {
        member.setId(sequence++);
        store.put(member.getId(), member);
        return member;
    }

    public Optional<Member> updateMember(Member member) {
        Member previousValue = store.put(member.getId(), member);
        if (previousValue != null) {
            return Optional.of(member);
        }
        return Optional.empty();
    }

    public boolean deleteMemberById(long id) {
        Member deletedMember = store.remove(id);
        return deletedMember != null;
    }
}
