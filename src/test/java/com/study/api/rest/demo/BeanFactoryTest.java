package com.study.api.rest.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import static org.assertj.core.api.Assertions.assertThat;

public class BeanFactoryTest {
    @Test
    @DisplayName("Spring IoC Container를 통해 ObjectMapper 객체 얻기 테스트")
    void getObjectMapper() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();

        beanDefinition.setBeanClass(ObjectMapper.class);

        beanFactory.registerBeanDefinition("objectMapper", beanDefinition);

        ObjectMapper objectMapper = beanFactory.getBean("objectMapper", ObjectMapper.class); // 이름으로 얻기
        // 얻는 방법이 다양함 타입도 있음.

        assertThat(objectMapper).isNotNull();
    }

//    @Test
//    @DisplayName("Spring IoC Container를 통해 PostController 객체 얻기 테스트")
//    void getPostController() {
//        BeanFactory beanFactory;
//
//        ObjectMapper objectMapper = beanFactory.getBean("objectMapper"); // 이름으로 얻기
//    }
}
