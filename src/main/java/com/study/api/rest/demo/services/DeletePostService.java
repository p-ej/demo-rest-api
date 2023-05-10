package com.study.api.rest.demo.services;

import com.study.api.rest.demo.dtos.PostDto;
import com.study.api.rest.demo.models.Post;
import com.study.api.rest.demo.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class DeletePostService {
    private final PostRepository postRepository;

    public DeletePostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDto deletePost(String id) {
        Post post = postRepository.find(id);
        postRepository.delete(id);
        return new PostDto(post);
    }
}
