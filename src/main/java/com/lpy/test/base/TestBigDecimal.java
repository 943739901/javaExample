package com.lpy.test.base;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.lpy.test.base.model.Score;
import org.junit.Test;

public class TestBigDecimal {

    @Test
    public void test() {
        BigDecimal b =
//                new BigDecimal("-1");
                new BigDecimal("0.001");
//        null;

        BigDecimal price = b == null ? BigDecimal.ZERO : b;

//        if (BigDecimal.ZERO.compareTo(price) == 0
//                || BigDecimal.ZERO.compareTo(price) > 0) {
//            System.out.println("小于等于0");
//        }

        if (BigDecimal.ZERO.compareTo(price) < 0
                && new BigDecimal("0.01").compareTo(price) > 0) {
            System.out.println("大于0 小于0.01");
        }
    }


    @Test
    public void test1() {
        List<Score> scores = new ArrayList<>();
        scores.add(new Score(0.1));
        scores.add(new Score(null));
        scores.add(new Score(0.3));
        double sum = scores.stream().mapToDouble(sc -> Optional.ofNullable(sc.getScore()).orElse(0d)).sum();
        System.out.println(sum);
    }
}























