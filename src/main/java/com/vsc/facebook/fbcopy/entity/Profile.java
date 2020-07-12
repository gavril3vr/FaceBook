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

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image profileImage;

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

}
