package com.vsc.facebook.fbcopy.entity;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false, unique = false)
    private String password;

    @Column(name = "is_active", nullable = false, unique = false)

    private boolean isActive;

    @Column(name = "first_name", nullable = false, unique = false)
    private String firstName;

    @Column(name = "last_name", nullable = false, unique = false)
    private String lastName;

    @Column(name = "age", nullable = false)
    private Integer age;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})

    private Set<Role> authorities;

    @OneToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Image> images;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "connections")
    private Set<User> friends;

    @ManyToMany
    @JoinTable(name = "users_friends",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "friend_id")})
    private Set<User> connections;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "blockedBy")
    private Set<User> blockedUsers;
    @JoinTable(name = "blocked_users",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "blocked_user_id")})
    @ManyToMany
    private Set<User> blockedBy;

    @Column(name = "register_date")
    private Date registerDate;

    @OneToMany(mappedBy = "poster", fetch = FetchType.LAZY)
    private Set<Post> posts;

    @ManyToMany(mappedBy = "likes", fetch = FetchType.LAZY)
    private Set<Post> likedPosts;

    @ManyToMany(mappedBy = "shares", fetch = FetchType.LAZY)
    private Set<Post> sharedPosts;

    @OneToMany(mappedBy = "requester", fetch = FetchType.LAZY)
    private Set<FriendRequestEntity> requests;

    @OneToMany(mappedBy = "requested", fetch = FetchType.LAZY)
    private Set<FriendRequestEntity> otherRequest;


    public User() {

    }


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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<User> getConnections() {
        return connections;
    }

    public void setConnections(Set<User> connections) {
        this.connections = connections;
    }

    public Set<User> getBlockedBy() {
        return blockedBy;
    }

    public void setBlockedBy(Set<User> blockedBy) {
        this.blockedBy = blockedBy;
    }

    public Set<FriendRequestEntity> getRequests() {
        return requests;
    }

    public void setRequests(Set<FriendRequestEntity> requests) {
        this.requests = requests;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public Set<User> getBlockedUsers() {
        return blockedUsers;
    }

    public void setBlockedUsers(Set<User> blockedUsers) {
        this.blockedUsers = blockedUsers;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Post> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(Set<Post> likedPosts) {
        this.likedPosts = likedPosts;
    }

    public Set<Post> getSharedPosts() {
        return sharedPosts;
    }

    public void setSharedPosts(Set<Post> sharedPosts) {
        this.sharedPosts = sharedPosts;
    }

}