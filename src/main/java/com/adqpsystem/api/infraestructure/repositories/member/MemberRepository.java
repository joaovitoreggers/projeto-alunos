package com.adqpsystem.api.infraestructure.repositories.member;

import com.adqpsystem.api.domain.entities.member.Member;
import com.adqpsystem.api.domain.entities.shared.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MemberRepository extends JpaRepository<Member, UUID> {
    boolean existsByEmail(Email email);

}
