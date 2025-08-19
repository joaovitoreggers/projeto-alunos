package com.adqpsystem.api.application.services.member.MemberMapper;

import com.adqpsystem.api.api.dto.member.MemberCreateDTO;
import com.adqpsystem.api.api.dto.member.MemberResponseDTO;
import com.adqpsystem.api.domain.entities.member.Member;
import com.adqpsystem.api.domain.entities.shared.AuditInfo;

import java.time.LocalDate;
import java.time.ZoneId;

public class MemberMapper {

    public static Member fromDto(MemberCreateDTO dto) {
        return Member.create(
                dto.name(),
                dto.email(),
                dto.description(),
                dto.birthday(),
                dto.baptismDate(),
                dto.gender(),
                dto.street(),
                dto.city(),
                dto.state(),
                dto.zipCode(),
                dto.coutry(),
                dto.martialStatus(),
                dto.phoneNumber(),
                AuditInfo.recordCreation()
        );
    }

    public static MemberResponseDTO toResponse(Member member) {
        LocalDate birthday = member.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDate baptismDate = member.getBaptismDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return new MemberResponseDTO(
                member.getId(),
                member.getName(),
                member.getEmail().toString(),
                member.getDescription(),
                birthday,
                baptismDate,
                member.getGender(),
                member.getAddress().getStreet(),
                member.getAddress().getCity(),
                member.getAddress().getState(),
                member.getAddress().getZipCode(),
                member.getAddress().getCountry(),
                member.getMartialStatus(),
                member.getPhoneNumber().getNumber()
        );
    }
}
