package com.study.api.rest.demo.services;

import com.study.api.rest.demo.dtos.PostDto;
import com.study.api.rest.demo.models.MultiLineText;
import com.study.api.rest.demo.models.Post;
import com.study.api.rest.demo.models.PostId;
import com.study.api.rest.demo.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class CreatePostService {
    private final PostRepository postRepository;

    public CreatePostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostDto createPost(PostDto postDto) {
        Post post = new Post(
                PostId.of(postDto.getId()),
                postDto.getTitle(),
                MultiLineText.of(postDto.getContent())
        );
        postRepository.createPost(post);
        return new PostDto(post);
    }
}
