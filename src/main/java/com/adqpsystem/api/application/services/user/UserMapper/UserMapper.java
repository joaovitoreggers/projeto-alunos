package com.adqpsystem.api.application.services.user.UserMapper;

import com.adqpsystem.api.api.dto.user.UserCreateDTO;
import com.adqpsystem.api.api.dto.user.UserResponseDTO;
import com.adqpsystem.api.domain.entities.shared.AuditInfo;
import com.adqpsystem.api.domain.entities.users.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {
    public static UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail().toString(),
                user.isActive(),
                user.getAudit().getCreatedAt()
        );
    }

    public static User fromDto(UserCreateDTO dto, PasswordEncoder passwordEncoder) {
        AuditInfo audit = AuditInfo.recordCreation();
        return User.create(
                dto.name(),
                dto.email(),
                dto.password(),
                passwordEncoder,
                audit
        );
    }
}
