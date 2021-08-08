package com.lpy.test.base;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author lipengyu
 */
public class TestEncoder {

    /**
     * nacos密码
     */
    @Test
    public void test() {
        String encode = new BCryptPasswordEncoder().encode("nacos");
        System.out.println(encode);
    }
}
