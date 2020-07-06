package com.vsc.facebook.fbcopy.entity;

import javafx.scene.Parent;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = User.class, optional = false)
    private User poster;

    @Column(name = "post", nullable = false)
    private String post;

    @Column(name = "postDate", nullable = false)
    private String postDate;

    @ManyToOne(targetEntity = Post.class, optional = false)
    private Post parent;

    @ManyToMany
    private Set<User> likes;

    @ManyToMany
    private Set<User> shares;

    @OneToMany
    private Set<Post> comments;

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getPoster() {
        return poster;
    }

    public void setPoster(User poster) {
        this.poster = poster;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public Post getParent() {
        return parent;
    }

    public void setParent(Post parent) {
        this.parent = parent;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }

    public Set<User> getShares() {
        return shares;
    }

    public void setShares(Set<User> shares) {
        this.shares = shares;
    }

    public Set<Post> getComments() {
        return comments;
    }

    public void setComments(Set<Post> comments) {
        this.comments = comments;
    }
}
