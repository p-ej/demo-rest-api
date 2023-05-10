package com.study.api.rest.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    //    @Autowired
//    PostController postController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void list() throws Exception {
//        PostController postController = new PostController();
//        postController.list(); // 실제로 있다 확인 하는 방법임.

        mockMvc.perform(get("/posts"))
                .andExpect(status().isOk())
                .andExpect(content().string(
                        containsString("제목"))
                );
    }
}