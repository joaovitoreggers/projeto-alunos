package com.adqpsystem.api.application.services.user;

import com.adqpsystem.api.api.dto.user.UserResponseDTO;
import com.adqpsystem.api.application.services.user.UserMapper.UserMapper;
import com.adqpsystem.api.infraestructure.repositories.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserQueryService {
    private final UserRepository userRepository;

    public List<UserResponseDTO> findAllActiveUsers() {
        return userRepository.findByActiveTrue()
                .stream()
                .map(UserMapper::toResponse)
                .toList();
    }

    public List<UserResponseDTO> findAllInactiveUsers() {
        return userRepository.findByActiveFalse()
                .stream()
                .map(UserMapper::toResponse)
                .toList();
    }
}
