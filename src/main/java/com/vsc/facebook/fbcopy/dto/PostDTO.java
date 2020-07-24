package com.vsc.facebook.fbcopy.dto;

import com.vsc.facebook.fbcopy.entity.Post;

public class PostDTO {

    private String post;
    private Post parent;
    private Long parentId;

    public PostDTO() {
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Post getParent() {
        return parent;
    }

    public void setParent(Post parent) {
        this.parent = parent;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
