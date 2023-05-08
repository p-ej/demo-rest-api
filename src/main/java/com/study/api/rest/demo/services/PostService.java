package com.study.api.rest.demo.services;

import com.study.api.rest.demo.Factory;
import com.study.api.rest.demo.daos.PostDAO;
import com.study.api.rest.demo.dtos.PostDto;
import com.study.api.rest.demo.models.Post;
import com.study.api.rest.demo.repositories.PostRepository;

import java.util.List;
import java.util.UUID;

public class PostService {
    //    private final PostDAO postDAO;
    private final PostRepository postRepository;

    public PostService(PostDAO postDAO) {
        // PostDAO 인터페이스만 알면 좋은데 다른것도 여기서 알게 됨.
//        this.postDAO = new PostListDAO();
        postRepository = Factory.postRepository();
    }

    public List<PostDto> getPostDtos() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> new PostDto(post)).toList();
    }

//    public PostDto getPostDto(String id) {
//        return postDAO.find(id);
//    }

    public PostDto createPost(PostDto postDto) {
        String id = UUID.randomUUID().toString();
        PostDto newPostDto = new PostDto();
        newPostDto.setId(id);
        newPostDto.setTitle(postDto.getTitle());
        newPostDto.setContent(postDto.getContent());

//        postDAO.save(newPostDto);
        return postDto;
    }

    public void updatePost(String id, PostDto postDto) {
//        PostDto found = postDAO.find(id);
//        found.setTitle(postDto.getTitle());
//        found.setContent(postDto.getContent());
//        return found;
//        return ;
    }

    public void deletePost(String id) {
//        PostDto postDto = postDAO.find(id);
//
//        postDAO.delete(id);
//
//        return postDto;
    }

}
