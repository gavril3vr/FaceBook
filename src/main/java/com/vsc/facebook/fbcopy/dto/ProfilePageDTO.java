package com.vsc.facebook.fbcopy.dto;

import com.vsc.facebook.fbcopy.entity.Image;
import com.vsc.facebook.fbcopy.entity.Post;

public class ProfilePageDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String age;
    private Image avatar;
    private Post posts;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public Post getPosts() {
        return posts;
    }

    public void setPosts(Post posts) {
        this.posts = posts;
    }

    public ProfilePageDTO() {
    }
}
