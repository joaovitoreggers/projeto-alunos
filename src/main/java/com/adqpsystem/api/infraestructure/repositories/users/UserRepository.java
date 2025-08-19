package com.adqpsystem.api.infraestructure.repositories.users;

import com.adqpsystem.api.domain.entities.shared.Email;
import com.adqpsystem.api.domain.entities.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.UUID;
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByEmail(Email email);
    List<User> findByActiveTrue();
    List<User> findByActiveFalse();
/*
    @Query("""
    SELECT u
      FROM User u
     WHERE u.active = true
       AND (:name IS NULL OR LOWER(u.name) LIKE LOWER(CONCAT('%', :name, '%')))
       AND (:email IS NULL OR LOWER(u.email) = LOWER(:email))
    """)
    List<User> findActiveUsersByNameOrEmail(
            @Param("name")  String name,
            @Param("email") String email
    );


 */

}
