package com.example.springboot_jpa_osiv.controller;

import com.example.springboot_jpa_osiv.dto.MemberChangeRequest;
import com.example.springboot_jpa_osiv.dto.MemberChangeResponse;
import com.example.springboot_jpa_osiv.dto.MemberResponse;
import com.example.springboot_jpa_osiv.entity.Member;
import com.example.springboot_jpa_osiv.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @PatchMapping("/member")
    ResponseEntity<MemberChangeResponse> changeNickname(Member member, @RequestBody MemberChangeRequest request) {
        MemberChangeResponse response = memberService.changeNickname(member, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/member")
    ResponseEntity<MemberResponse> getNickname() {
        MemberResponse response = memberService.getMemberNickname();
        return ResponseEntity.ok(response);
    }
}
