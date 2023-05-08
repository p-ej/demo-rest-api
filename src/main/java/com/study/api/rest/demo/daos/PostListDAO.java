package com.study.api.rest.demo.daos;

import com.study.api.rest.demo.dtos.PostDto;
import com.study.api.rest.demo.exceptions.PostNotFound;

import java.util.ArrayList;
import java.util.List;

public class PostListDAO implements PostDAO {
    private final List<PostDto> postDtos;

    public PostListDAO() {
        this.postDtos = new ArrayList<>();
    }

    @Override
    public List<PostDto> findAll() {
        return new ArrayList<>(postDtos);// 캡슐화가 깨지는 것을 방지하기 위해 새로 만들어서 줌
    }

    @Override
    public PostDto find(String id) {
        return postDtos.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElseThrow(PostNotFound::new);
    }

    @Override
    public void save(PostDto postDto) {
        postDtos.add(postDto);
    }

    @Override
    public void delete(String id) {
        PostDto postDto = postDtos.stream()
                .filter(post -> post.getId().equals(id))
                .findFirst()
                .orElseThrow(PostNotFound::new);
        postDtos.remove(postDto);
    }
}
