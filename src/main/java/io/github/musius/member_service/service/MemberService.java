package io.github.musius.member_service.service;

import io.github.musius.member_service.model.Member;
import io.github.musius.member_service.respository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return memberRepository.findMemberById(id);
    }

    public Member createMember(Member member) {
        return memberRepository.createMember(member);
    }

    public Optional<Member> updateMember(Member member) {
        return memberRepository.updateMember(member);
    }

    public void deleteMemberById(long id) {
        memberRepository.deleteMemberById(id);
    }
}
