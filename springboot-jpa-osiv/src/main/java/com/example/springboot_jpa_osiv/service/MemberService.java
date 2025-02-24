package com.example.springboot_jpa_osiv.service;

import com.example.springboot_jpa_osiv.dto.MemberChangeRequest;
import com.example.springboot_jpa_osiv.dto.MemberChangeResponse;
import com.example.springboot_jpa_osiv.dto.MemberResponse;
import com.example.springboot_jpa_osiv.entity.Member;
import com.example.springboot_jpa_osiv.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private static final Long TARGET_MEMBER_ID = 1L;
    private final MemberRepository memberRepository;

    @Transactional
    public MemberChangeResponse changeNickname(Member member, MemberChangeRequest request) {
        member.changeNickname(request.nickname());
        return new MemberChangeResponse(request.nickname());
    }

    public MemberResponse getMemberNickname() {
        Member member = memberRepository.findById(TARGET_MEMBER_ID)
                .orElseThrow(() -> new EntityNotFoundException("member가 존재하지 않습니다."));
        return new MemberResponse(member.getNickname());
    }
}
