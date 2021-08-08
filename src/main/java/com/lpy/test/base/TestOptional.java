package com.lpy.test.base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author lipengyu
 */
public class TestOptional {

    @Test
    public void test() {
        Optional<Object> o = Optional.ofNullable(null);
        Object o1 = o.get();
        System.out.println(o1);
    }

    @Test
    public void test1() {
        Object o = Optional.ofNullable(null).orElse(null);
        System.out.println(o);
    }

    @Test
    public void test2() {
        Optional.ofNullable(null).ifPresent(a -> {
            System.out.println("1111");
        });
    }

    @Test
    public void test3() {
        List<String> nullList = null;
        List<String> list = Optional.ofNullable(nullList).orElse(new ArrayList<>());
        list.forEach(System.out::println);
    }

    /**
     * Optional.ofNullable() 是当为空时 返回value为null的Optional 不为空时调用Optional.of()
     * of 中 会new Optional(value) 如果value为空则直接报错
     */
    @Test
    public void test4() {
        List<String> nullList = null;
        List<String> list = Optional.ofNullable(nullList).orElseThrow(() -> new RuntimeException("null"));
        list.forEach(System.out::println);
    }
}
