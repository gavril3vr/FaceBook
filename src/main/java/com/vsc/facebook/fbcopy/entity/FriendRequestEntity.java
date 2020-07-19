package com.vsc.facebook.fbcopy.entity;

import com.vsc.facebook.fbcopy.enumaration.FriendRequestStatus;

import javax.persistence.*;

@Entity
@Table(name = "friend_requests")
public class FriendRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Enumerated
    private FriendRequestStatus status;

    public FriendRequestEntity() {
        this.id = id;
        this.status = status;
    }

    @ManyToOne( fetch = FetchType.LAZY)
    private User requester;

    @ManyToOne( fetch = FetchType.LAZY)
    private User requested;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FriendRequestStatus getStatus() {
        return status;
    }

    public void setStatus(FriendRequestStatus status) {
        this.status = status;
    }
}
