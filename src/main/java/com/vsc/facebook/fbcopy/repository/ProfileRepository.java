package com.vsc.facebook.fbcopy.repository;

import com.vsc.facebook.fbcopy.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Post, Long> {
}
