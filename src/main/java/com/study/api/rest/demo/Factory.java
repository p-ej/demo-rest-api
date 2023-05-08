package com.study.api.rest.demo;

import com.study.api.rest.demo.repositories.PostRepository;

public class Factory {
    private static PostRepository postRepository;

    public static PostRepository postRepository() {
        if (postRepository == null) {
            postRepository = new PostRepository();
        }
        return postRepository();
    }
}
