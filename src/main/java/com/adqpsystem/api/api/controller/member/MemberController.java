package com.adqpsystem.api.api.controller.member;

import com.adqpsystem.api.api.dto.member.MemberResponseDTO;
import com.adqpsystem.api.domain.entities.member.Member;
import com.adqpsystem.api.api.dto.member.MemberCreateDTO;
import com.adqpsystem.api.application.services.member.MemberCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/members")
public class MemberController {

    private final MemberCreateService memberService;

    @PostMapping("/create")
    public ResponseEntity<MemberResponseDTO> createMember(@RequestBody MemberCreateDTO memberDTO) {
        MemberResponseDTO newMember = memberService.create(memberDTO);
        URI location = URI.create("/api/v1/members/" + newMember.id());
        return ResponseEntity.created(URI.create("/api/v1/users/" + newMember.id())).body(newMember);
    }
}
