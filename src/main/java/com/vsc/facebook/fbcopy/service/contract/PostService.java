package com.vsc.facebook.fbcopy.service.contract;

import com.vsc.facebook.fbcopy.dto.PostDTO;
import com.vsc.facebook.fbcopy.entity.User;

public interface PostService {
    void createPost(PostDTO postDTO, User user);
    void addComment(PostDTO postDTO, User user);
}
