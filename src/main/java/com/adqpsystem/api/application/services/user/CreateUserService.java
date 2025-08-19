package com.adqpsystem.api.application.services.user;

import com.adqpsystem.api.api.dto.user.UserCreateDTO;
import com.adqpsystem.api.api.dto.user.UserResponseDTO;
import com.adqpsystem.api.application.services.user.UserMapper.UserMapper;
import com.adqpsystem.api.domain.entities.shared.Email;
import com.adqpsystem.api.domain.entities.users.User;
import com.adqpsystem.api.infraestructure.repositories.users.UserRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDTO create(UserCreateDTO dto) {
        if (userRepository.existsByEmail(Email.of(dto.email()))) {
            throw new EntityExistsException("Email já cadastrado!");
        }

        User newUser = UserMapper.fromDto(dto, passwordEncoder);

        userRepository.save(newUser);
        return UserMapper.toResponse(newUser);
    }
}
