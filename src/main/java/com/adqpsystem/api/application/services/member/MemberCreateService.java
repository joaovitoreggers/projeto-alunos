package com.adqpsystem.api.application.services.member;

import com.adqpsystem.api.api.dto.member.MemberResponseDTO;
import com.adqpsystem.api.application.services.member.MemberMapper.MemberMapper;
import com.adqpsystem.api.domain.entities.member.Member;
import com.adqpsystem.api.api.dto.member.MemberCreateDTO;
import com.adqpsystem.api.domain.entities.shared.Email;
import com.adqpsystem.api.infraestructure.repositories.member.MemberRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberCreateService {


    private final MemberRepository memberRepository;

    public MemberResponseDTO create(MemberCreateDTO dto) {
        if (memberRepository.existsByEmail(Email.of(dto.email()))) {
            throw new EntityExistsException("Email já cadastrado!");
        }

        Member newMember = MemberMapper.fromDto(dto);
        memberRepository.save(newMember);
        return MemberMapper.toResponse(newMember);
    }
}