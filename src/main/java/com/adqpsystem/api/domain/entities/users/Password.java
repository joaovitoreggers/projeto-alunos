package com.adqpsystem.api.domain.entities.users;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@NoArgsConstructor
@Embeddable
public final class Password {

    private String password_hash;

    private Password(String hash) {
        this.password_hash = hash;
    }

    // CRIA A O HASH A PARTIR DA SENHA FORNECIDA PELO USUÁRIO
    public static Password hash(String plainText, PasswordEncoder encoder) {
        if (!isValid(plainText)) {
            throw new IllegalArgumentException("""
                A senha deve conter no mínimo 8 caracteres, incluindo:
                - uma letra minúscula,
                - uma letra maiúscula,
                - um número,
                - um caractere especial.
            """);
        }

        String encoded = encoder.encode(plainText);
        return new Password(encoded);
    }

    // VERIFICA SE A SENHA CONDIZ COM A ARMAZENADA
    public boolean matches(String plainText, PasswordEncoder encoder) {
        return plainText != null && encoder.matches(plainText, this.password_hash);
    }

    // VALIDA A SENHA
    private static boolean isValid(String plainText) {
        return plainText != null
                && plainText.length() >= 8
                && plainText.matches(".*[a-z].*")        // letra minúscula
                && plainText.matches(".*[A-Z].*")        // letra maiúscula
                && plainText.matches(".*\\d.*")          // número
                && plainText.matches(".*[^a-zA-Z0-9].*"); // caractere especial
    }
}
