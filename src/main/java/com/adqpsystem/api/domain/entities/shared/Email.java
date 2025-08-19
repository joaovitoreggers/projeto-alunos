package com.adqpsystem.api.domain.entities.shared;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.regex.Pattern;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public final class Email {

    // VALIDA O FORMATO DE EMAIL
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$",
            Pattern.CASE_INSENSITIVE
    );

    private String email;

    private Email(String value) {
        this.email = value.toLowerCase();
    }

    // CRIA O EMAIL
    public static Email of(String emailAddress) {
        if (emailAddress == null || !EMAIL_PATTERN.matcher(emailAddress).matches()) {
            throw new IllegalArgumentException("Formato de e-mail inválido: " + emailAddress);
        }
        return new Email(emailAddress);
    }

    // RETORNA O EMAIL
    public String value() {
        return email;
    }
}
