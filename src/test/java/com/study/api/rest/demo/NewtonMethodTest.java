package com.study.api.rest.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.assertj.core.api.Assertions.assertThat;

public class NewtonMethodTest {
    private NewtonMethod sut; // 여기서 생성하면 보장 어렵
    private static final DecimalFormat DECIMAL_FORMAT =
            new DecimalFormat("0.######");
    ;

    @BeforeEach
        // 시작하기 전 이거실행 필요 객체초기화 및 같은 객체 공유 (공통사용)
    void setUp() {
        sut = new NewtonMethod();
    }

    @Test
    @DisplayName("제곱근과 비슷한 값인지 확인하는 goodEnough 메서드를 테스트")
    void goodEnough() {
        assertThat(sut.goodEnough(2, 4)).isTrue(); // 2에 대한 제곱근으로 1이 맞느냐
        assertThat(sut.goodEnough(1, 4)).isFalse();

        // 근사치 구하기
        assertThat(sut.goodEnough(1.9999999, 4)).isTrue();

        assertThat(sut.goodEnough(-1.9999999, 4)).isFalse();
    }

    @Test
    void improve() {

        assertThat(DECIMAL_FORMAT.format(sut.improve(1, 2))).isEqualTo("1.5");
        assertThat(DECIMAL_FORMAT.format(sut.improve(1.5, 2))).isEqualTo("1.416667");
        assertThat(DECIMAL_FORMAT.format(sut.improve(1.416667, 2))).isEqualTo("1.414216");
    }

    @Test
    void average() {
        assertThat(sut.average(1, 2)).isEqualTo(1.5);
        assertThat(sut.average(2, 2)).isEqualTo(2);
        assertThat(sut.average(0, 2)).isEqualTo(1);
        assertThat(sut.average(-2, 2)).isEqualTo(0);
        assertThat(sut.average(-Double.MAX_VALUE, Double.MAX_VALUE)).isEqualTo(0);
//        assertThat(sut.average(Double.MAX_VALUE, Double.MAX_VALUE)).isEqualTo(Double.MAX_VALUE);
        assertThat(sut.average(-Integer.MAX_VALUE, Integer.MAX_VALUE)).isEqualTo(0);
        assertThat(sut.average(Integer.MAX_VALUE, Integer.MAX_VALUE)).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    void sqrtIter() {

        assertThat(DECIMAL_FORMAT.format(sut.sqrtIter(1, 2)))
                .isEqualTo("1.414216");
        assertThat(DECIMAL_FORMAT.format(sut.sqrtIter(1, 3)))
                .isEqualTo("1.732051");
        assertThat(DECIMAL_FORMAT.format(sut.sqrtIter(1, 4)))
                .isEqualTo("2");
    }

    @Test
    void sqrt() {
        assertThat(DECIMAL_FORMAT.format(sut.sqrt(2))).isEqualTo("1.414216");
        assertThat(DECIMAL_FORMAT.format(sut.sqrt(3))).isEqualTo("1.732051");
        assertThat(DECIMAL_FORMAT.format(sut.sqrt(4))).isEqualTo("2");
    }
}
