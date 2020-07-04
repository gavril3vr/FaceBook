package com.vsc.facebook.fbcopy.repository;

import com.vsc.facebook.fbcopy.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
