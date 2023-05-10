package com.study.api.rest.demo;

import com.study.api.rest.demo.dtos.PostDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PostFeatureTest {
    @Value("${local.server.port}")
    private int port;

    @Autowired // 테슽 할때만 만들어지는 의존성
    private TestRestTemplate restTemplate;

//    @Test
//    @DisplayName("게시물 목록 확인")
//    void list() {
//        String url = "http://localhost:" + port + "/posts";
//
//        String body = restTemplate.getForObject(url, String.class);
//
//        assertThat(body).contains("제목"); // 가져온 데이터안에 해당 문자열이 있는지 확인
//    }

    @Test
    @DisplayName("게시물 등록 후 목록 확인")
    void postAfterList() {
        String url = "http://localhost:" + port + "/posts";

//        PostDto postDto =

        restTemplate.postForLocation(url, new PostDto("5", "NEW POST", "."));
        restTemplate.postForLocation(url, new PostDto("6", "새 글", "제곧내"));

        String body = restTemplate.getForObject(url, String.class);
        
        assertThat(body).contains("NEW POST");
        assertThat(body).contains("새 글"); // 가져온 데이터안에 해당 문자열이 있는지 확인
        assertThat(body).contains("제곧내"); // 가져온 데이터안에 해당 문자열이 있는지 확인

        // id를 얻으려고 한다. (정규표현식)
        String id = findLastId(body);

        restTemplate.delete(url + "/" + id);

        body = this.restTemplate.getForObject(url, String.class);


        assertThat(body).doesNotContain(id);
        assertThat(body).doesNotContain("새 글");
        assertThat(body).doesNotContain("제곧내");
//        assertThat(body).contains("제곧내");
    }

    private String findLastId(String body) {
        Pattern pattern = Pattern.compile("\"id\":\"([^\"]+)\"");
        Matcher matcher = pattern.matcher(body);

        String id = "";
        while (matcher.find()) {
            id = matcher.group(1);
        }
        return id;
    }
}
