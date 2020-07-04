package com.vsc.facebook.fbcopy.repository;

import com.vsc.facebook.fbcopy.entity.Post;
import com.vsc.facebook.fbcopy.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository {

}
