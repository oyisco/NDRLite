package com.NDRLite.domain.repositories;

import java.util.Optional;

import com.NDRLite.domain.ERole;
import com.NDRLite.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
