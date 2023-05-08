package com.study.api.rest.demo.repositories;

import com.study.api.rest.demo.models.MultiLineText;
import com.study.api.rest.demo.models.Post;
import com.study.api.rest.demo.models.PostId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostRepository {
    private final Map<PostId, Post> posts;

    public PostRepository() {
        this.posts = new HashMap<PostId, Post>();


        this.posts.put(PostId.of("1"),
                new Post(PostId.of("1"), "t", MultiLineText.of("테스트입니다")));
        this.posts.put(PostId.of("2"),
                new Post(PostId.of("2"), "zz", MultiLineText.of("2등이다")));

    }

    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }

    public Post find(String id) {
        return posts.get(PostId.of(id));
    }
}
