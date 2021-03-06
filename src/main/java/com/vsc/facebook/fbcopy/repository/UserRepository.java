package com.vsc.facebook.fbcopy.repository;

import com.vsc.facebook.fbcopy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByEmail(String email);

    boolean existsByEmail(String email);

    //Optional<User> findAllByPassword(String truePass);
}
