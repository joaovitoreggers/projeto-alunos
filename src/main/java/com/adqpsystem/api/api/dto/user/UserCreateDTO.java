package com.adqpsystem.api.api.dto.user;

import com.adqpsystem.api.domain.entities.shared.AuditInfo;
import org.springframework.security.crypto.password.PasswordEncoder;


public record UserCreateDTO(String name, String email, String password, PasswordEncoder passwordEncoder, AuditInfo auditInfo) {}
