package com.study.api.rest.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
//        ApplicationContext context =
//                new AnnotationConfigApplicationContext(DemoApplication.class);
//
//        GetPostDtoListService getPostDtoListService = context.getBean("getPostDtoListService", GetPostDtoListService.class);
//        PostController postController = context.getBean("postController", PostController.class);
//
//        System.out.println("-".repeat(80));
//        System.out.println(postController);
//        System.out.println("-".repeat(80));
//        System.out.println(getPostDtoListService);
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    public PostRepository postRepository() {
//        return new PostRepository();
//    }
//
//
//    @Bean
//    public GetPostDtoListService getPostDtoListService() {
//        return new GetPostDtoListService(postRepository());
//    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                        .allowedOrigins("http://localhost:3000")
                        .allowedOrigins("*")
                ;
            }
        };
    }

}
