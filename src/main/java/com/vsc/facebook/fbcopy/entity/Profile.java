package com.vsc.facebook.fbcopy.entity;

import javax.persistence.*;

@Entity
@Table(name = "profiles")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_Name")
    private String fullName;

    @Column(name = "is_full_name_public")
    private boolean isFullNamePublic;

    @Column(name = "profile_image")
    @OneToOne
    private Image profileImage;

    @Column(name = "user")
    @OneToOne
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isFullNamePublic() {
        return isFullNamePublic;
    }

    public void setFullNamePublic(boolean fullNamePublic) {
        isFullNamePublic = fullNamePublic;
    }

    public Image getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Image profileImage) {
        this.profileImage = profileImage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
