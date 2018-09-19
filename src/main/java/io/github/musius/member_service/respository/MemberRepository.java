package io.github.musius.member_service.respository;

import com.hazelcast.core.IdGenerator;
import io.github.musius.member_service.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public class MemberRepository {
    private final Map<Long, Member> store;

    private final IdGenerator idGenerator;

    @Autowired
    public MemberRepository(@Qualifier("membersBackingMap") Map<Long, Member> store,
                            @Qualifier("membersIdGenerator") IdGenerator idGenerator) {
        this.store = store;
        this.idGenerator = idGenerator;
    }

    public Optional<Member> findMemberById(long id) {
        return Optional.ofNullable(store.getOrDefault(id, null));
    }

    public Member createMember(Member member) {
        member.setId(idGenerator.newId());
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

    public void deleteMemberById(long id) {
        store.remove(id);
    }
}
