package com.example.springboot_jpa_osiv.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.springboot_jpa_osiv.dto.MemberChangeRequest;
import com.example.springboot_jpa_osiv.entity.Member;
import com.example.springboot_jpa_osiv.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberServiceTest extends SpringServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Test
    void 회원_이름을_변경할_수_있다() {
        // given
        Member member = memberFixture.createMember("test");
        MemberChangeRequest request = new MemberChangeRequest("changeNick");

        // when
        memberService.changeNickname(member, request);
        String actual = memberRepository.findById(member.getId()).get().getNickname();

        // then
        assertThat(actual).isEqualTo("changeNick");
    }
}
