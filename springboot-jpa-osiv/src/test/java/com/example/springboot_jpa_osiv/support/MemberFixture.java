package com.example.springboot_jpa_osiv.support;

import com.example.springboot_jpa_osiv.entity.Member;
import com.example.springboot_jpa_osiv.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MemberFixture {

    @Autowired
    MemberRepository memberRepository;

    @Transactional
    public Member createMember(String name) {
        Member newMember = new Member(name);
        return memberRepository.save(newMember);
    }
}
