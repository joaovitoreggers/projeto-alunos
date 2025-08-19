package com.adqpsystem.api.domain.entities.shared;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Embeddable
public final class AuditInfo {

    private  LocalDateTime createdAt;
    private  LocalDateTime updatedAt;

    private AuditInfo(LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    private AuditInfo() {}




    public static AuditInfo recordCreation() {
            LocalDateTime now = LocalDateTime.now();
            return new AuditInfo(now, now);
        }

        public AuditInfo recordUpdate() {
            return new AuditInfo(this.createdAt,  LocalDateTime.now());
        }

    }
