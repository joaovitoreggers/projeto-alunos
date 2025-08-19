package com.adqpsystem.api.domain.entities.member;

import lombok.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private  String country;

    private Address(String street, String city, String state, String zipCode, String country) {
        if (street == null || city == null || state == null || zipCode == null || country == null) {
            throw new IllegalArgumentException("Endereco inválido, todos os campos são obrigatórios");
        }
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    public static Address of(String street, String city, String state, String zipCode, String country) {
        return new Address(street, city, state, zipCode, country);
    }
}
