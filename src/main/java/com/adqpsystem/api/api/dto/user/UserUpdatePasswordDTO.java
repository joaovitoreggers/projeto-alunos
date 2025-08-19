package com.adqpsystem.api.api.dto.user;

import org.jetbrains.annotations.NotNull;

public record UserUpdatePasswordDTO(
        @NotNull("A senha antiga não pode ser nula") String oldPassword,
        @NotNull("A nova senha não pode ser nula") String newPassword) {
}
