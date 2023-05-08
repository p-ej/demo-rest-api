package com.study.api.rest.demo.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiLineTextTest {
    @Test
    void creation() {
        MultiLineText multiLineText = new MultiLineText("1\n2\n3");

        assertEquals("1\n2\n3", multiLineText.toString());
    }
}