package com.adqpsystem.api.application.services.user;

import com.adqpsystem.api.api.dto.user.UserUpdateEmailDTO;
import com.adqpsystem.api.api.dto.user.UserUpdateNameDTO;
import com.adqpsystem.api.api.dto.user.UserUpdatePasswordDTO;
import com.adqpsystem.api.domain.entities.shared.AuditInfo;
import com.adqpsystem.api.domain.entities.users.User;
import com.adqpsystem.api.infraestructure.repositories.users.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateUserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void updateName(UUID userId, UserUpdateNameDTO dto) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("User not found")
        );
        user.updateName(dto.name());
        user.updateAudit(AuditInfo.recordCreation());
        userRepository.save(user);
    }

    public void updateEmail(UUID userId, UserUpdateEmailDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        user.updateEmail(dto.oldEmail(), dto.newEmail());
        user.updateAudit(user.getAudit().recordUpdate());
        userRepository.save(user);
    }

    public void updatePassword(UUID userId, UserUpdatePasswordDTO dto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.updatePassword(dto.oldPassword(), dto.newPassword(), passwordEncoder);
        user.updateAudit(user.getAudit().recordUpdate());
        userRepository.save(user);
    }




}
