package com.adqpsystem.api.domain.entities.member;

import com.adqpsystem.api.domain.entities.member.enums.Gender;
import com.adqpsystem.api.domain.entities.member.enums.MartialStatus;
import com.adqpsystem.api.domain.entities.shared.AuditInfo;
import com.adqpsystem.api.domain.entities.shared.Email;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;
import java.time.ZoneId;

import java.util.Date;
import java.util.UUID;

@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name="member")
public class Member {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    @Embedded
    private Email email;

    private String description;


    private Date birthday;
    private Date baptismDate;

    @Embedded
    private PhoneNumber phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private MartialStatus martialStatus;

    @Embedded
    private AuditInfo audit;

    public Member(Date birthday, String name, Email email, String description, Date baptismDate, AuditInfo audit, MartialStatus martialStatus, Address address, Gender gender, PhoneNumber phoneNumber) {
        this.birthday = birthday;
        this.name = name;
        this.email = email;
        this.description = description;
        this.baptismDate = baptismDate;
        this.audit = audit;
        this.martialStatus = martialStatus;
        this.address = address;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public static @NonNull Member create(
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
            String country,
            MartialStatus martialStatus,
            String phoneNumber,
            AuditInfo audit
    ) {
        Date birthdayDate = (birthday != null) ? Date.from(birthday.atStartOfDay(ZoneId.systemDefault()).toInstant()) : null;
        Date baptism = (baptismDate != null) ? Date.from(baptismDate.atStartOfDay(ZoneId.systemDefault()).toInstant()) : null;

        Address address = Address.of(street, city, state, zipCode, country);
        PhoneNumber number = PhoneNumber.of(phoneNumber);
        Email newEmail = Email.of(email);

        return new Member(birthdayDate, name, newEmail, description, baptism, audit, martialStatus, address, gender, number);
    }

    public @NonNull String updateName(String newName) {
        this.name = newName;
        return this.name;
    }
/*
    public @NonNull String updateEmail(String newEmail) {

    }
*/

}
