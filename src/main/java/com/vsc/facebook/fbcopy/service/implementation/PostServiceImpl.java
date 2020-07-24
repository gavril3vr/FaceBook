package com.vsc.facebook.fbcopy.service.implementation;

import com.vsc.facebook.fbcopy.dto.PostDTO;
import com.vsc.facebook.fbcopy.entity.Post;
import com.vsc.facebook.fbcopy.entity.User;
import com.vsc.facebook.fbcopy.repository.PostRepository;
import com.vsc.facebook.fbcopy.service.contract.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.time.LocalDateTime;
import java.util.Date;

@Service
public class PostServiceImpl implements PostService {

        private final PostRepository postRepository;

        @Autowired
        public PostServiceImpl(PostRepository postRepository) {
            this.postRepository = postRepository;
        }

        @Override
        public void createPost(PostDTO postDTO, User user) {
            Post newPost = new Post();

            newPost.setPost(postDTO.getPost());
            newPost.setPoster(user);
            newPost.setPostDate(new Date());

            postRepository.save(newPost);
        }

        @Override
        public void addComment(PostDTO postDTO, User user) {
            Post comment = new Post();

            comment.setParent(postDTO.getParent());
            comment.setPoster(user);
            comment.setPost(postDTO.getPost());
            comment.setPostDate(new Date());

            postRepository.save(comment);
        }
}
