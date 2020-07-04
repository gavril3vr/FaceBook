package com.vsc.facebook.fbcopy.repository;

import com.vsc.facebook.fbcopy.entity.FriendRequestEntity;
import com.vsc.facebook.fbcopy.enumaration.FriendRequestStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequestEntity, Long> {

    //Optional<FriendRequestEntity> findFirstByIdAndStatus(Long id, FriendRequestStatus status);
}
