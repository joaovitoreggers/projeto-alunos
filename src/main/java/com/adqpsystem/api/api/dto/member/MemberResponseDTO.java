package com.adqpsystem.api.api.dto.member;

import com.adqpsystem.api.domain.entities.member.enums.Gender;
import com.adqpsystem.api.domain.entities.member.enums.MartialStatus;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.UUID;

public record MemberResponseDTO(
        @NonNull UUID id,
        @NonNull String name,
        @NonNull String email,
        @NonNull String description,
        @NonNull LocalDate birthday,
        @NonNull LocalDate baptismDate,
        @NonNull Gender gender,
        @NonNull String street,
        @NonNull String city,
        @NonNull String state,
        @NonNull String zipCode,
        @NonNull String country,
        @NonNull MartialStatus martialStatus,
        @NonNull String phoneNumber
) {}
