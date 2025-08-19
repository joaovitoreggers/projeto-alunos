package com.adqpsystem.api.api.dto.member;

import com.adqpsystem.api.domain.entities.member.enums.Gender;
import com.adqpsystem.api.domain.entities.member.enums.MartialStatus;
import java.time.LocalDate;

public record MemberCreateDTO(
        String name,
        String email,
        String description,
        LocalDate birthday,
        LocalDate baptismDate,
        Gender gender,
        String street,
        String city,
        String state,
        String zipCode,
        String coutry,
        MartialStatus martialStatus,
        String phoneNumber
) {}
