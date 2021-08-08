package com.lpy.test.base;

import org.junit.Test;

import java.util.Optional;
import java.util.Random;

/**
 * @author lipengyu
 */
public class TestRandom {

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Random().nextInt(3));
        }
    }
}
