package com.vsc.facebook.fbcopy.repository;

import com.vsc.facebook.fbcopy.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findFirstByAuthority(String authority);
}
