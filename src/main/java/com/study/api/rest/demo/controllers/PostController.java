package com.study.api.rest.demo.controllers;

import com.study.api.rest.demo.dtos.PostDto;
import com.study.api.rest.demo.exceptions.PostNotFound;
import com.study.api.rest.demo.services.GetPostDtoListService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    //    private final ObjectMapper objectMapper;
    private final GetPostDtoListService getPostDtoListService;

    public PostController() {
//        this.objectMapper = new objectMapper;
        getPostDtoListService = new GetPostDtoListService();
    }

    @GetMapping
    public List<PostDto> list(
            HttpServletResponse response
    ) {
        List<PostDto> postDtos = getPostDtoListService.getPostDtos();
        return postDtos;
    }

    // 범용
//    @GetMapping("/{id}")
//    public String detail(@PathVariable String id) throws JacksonException {
//        PostDto postDto = new PostDto("1234", "제목", "test");
//        String json = objectMapper.writeValueAsString(postDto);
//
//        return json;
//    }
//
    @GetMapping("/{id}")
    public PostDto detail(@PathVariable String id) {
        PostDto postDto = new PostDto(id, "제목", "test");

        return postDto;
    }

    // accept ?
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public PostDto create(@RequestBody String body) throws JsonProcessingException {
//        // 얻어온거 변환
//        PostDto postDto = objectMapper.readValue(body, PostDto.class);
//
//        return postDto;
//    }
    @CrossOrigin("*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PostDto create(@RequestBody PostDto postDto) {

        return postDto;
    }

    @PatchMapping("/{id}")
    public PostDto update(@PathVariable("id") String id, @RequestBody PostDto postDto) {
        postDto.setId(id);
        return postDto;
    }

    @DeleteMapping("/{id}")
    public PostDto delete(@PathVariable("id") String id) {
        PostDto postDto = new PostDto(id, "aa", "ddd");
        return postDto;
    }

    @ExceptionHandler(PostNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String postNotFound() {
        return "게시물을 찾을 수 없다.\n";
    }
}
