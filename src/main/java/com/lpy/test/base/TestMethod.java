package com.lpy.test.base;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author lipengyu
 * @date 2021/7/8 18:09
 */
public class TestMethod {

    @Test
    public void test() {
        List<String> str = getStr(2, null, null);
        System.out.println(str);
    }

    public List<String> getStr(Integer one, String... ignoreProperties) {

        System.out.println(ignoreProperties);
        return ignoreProperties != null ? Arrays.asList(ignoreProperties) : null;
    }
}
