package com.adqpsystem.api.application.services.user;

import com.adqpsystem.api.domain.entities.shared.AuditInfo;
import com.adqpsystem.api.domain.entities.users.User;
import com.adqpsystem.api.infraestructure.repositories.users.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserStatusService {
    private final UserRepository userRepository;

    public void deactivateUser(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("User not found"));
        user.deactivated();
        user.updateAudit(user.getAudit().recordUpdate());
        userRepository.save(user);
    }

    public void activateUser(UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("User not found")
        );
        user.activated();
        user.updateAudit(AuditInfo.recordCreation());
        userRepository.save(user);
    }
}
