package io.github.musius.member_service.respository;

import io.github.musius.member_service.model.Member;
import org.springframework.stereotype.Repository;
import org.springframework.data.hazelcast.repository.HazelcastRepository;

@Repository
public interface MemberRepository extends HazelcastRepository<Member, Long> {

}