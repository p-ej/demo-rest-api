package com.study.api.rest.demo.models;

import java.util.Objects;

public class PostId {
    private String id;

    public PostId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id;
    }

    public static PostId of(String id) {
        return new PostId(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostId postId = (PostId) o;
        return Objects.equals(id, postId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
