package com.adqpsystem.api.api.dto.user;

import org.jetbrains.annotations.NotNull;

public record UserUpdateNameDTO(@NotNull("O valor de nome não pode ser nulo") String name) {
}
