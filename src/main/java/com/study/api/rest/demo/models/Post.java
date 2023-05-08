package com.study.api.rest.demo.models;

public class Post {
    private PostId id;

    private String title;

    private MultiLineText content;

    public Post(PostId id, String title, MultiLineText content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public PostId id() {
        return id;
    }

    public String title() {
        return title;
    }

    public MultiLineText content() {
        return content;
    }
}
