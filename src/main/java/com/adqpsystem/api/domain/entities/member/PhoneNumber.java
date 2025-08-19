package com.adqpsystem.api.domain.entities.member;

import lombok.*;

import java.util.Objects;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PhoneNumber {
    private String number;

    private PhoneNumber (String number) {
        this.number = number;
    }

    public static PhoneNumber of(String rawNumber) {
        Objects.requireNonNull(rawNumber, "O número de telefone não pode ser nulo");

        String cleanNumber = rawNumber.replaceAll("[\\s().-]", "");
        if (cleanNumber.isEmpty()) {
            throw new IllegalArgumentException("Número de telefone não pode ser vazio");
        }
        if (!cleanNumber.matches("^\\+?\\d+$")) {
            throw new IllegalArgumentException("""
                    O número de telefone não está no formato requerido!
                    Formato requerido: +99 99 99999-9999
                    """);
        }
        return new PhoneNumber(cleanNumber);
    }

}
