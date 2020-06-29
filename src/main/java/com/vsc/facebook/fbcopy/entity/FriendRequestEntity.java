package com.vsc.facebook.fbcopy.entity;

import javax.persistence.*;

@Entity
public class FriendRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
