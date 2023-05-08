package com.study.api.rest.demo.services;

import com.study.api.rest.demo.Factory;
import com.study.api.rest.demo.dtos.PostDto;
import com.study.api.rest.demo.exceptions.PostNotFound;
import com.study.api.rest.demo.models.Post;
import com.study.api.rest.demo.repositories.PostRepository;

import java.util.List;

public class GetPostDtoListService {
    //    private final PostDAO postDAO;
    private final PostRepository postRepository;

    public GetPostDtoListService() {
        // PostDAO 인터페이스만 알면 좋은데 다른것도 여기서 알게 됨.
//        this.postDAO = new PostListDAO();
        postRepository = Factory.postRepository();
    }

    public List<PostDto> getPostDtos() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> new PostDto(post)).toList();
    }

    public PostDto getPostDto(String id) {
        Post post = postRepository.find(id);
        if (post == null) {
            throw new PostNotFound();
        }
        return new PostDto(post);
    }
}
