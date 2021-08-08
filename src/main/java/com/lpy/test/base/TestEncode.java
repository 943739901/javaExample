package com.lpy.test.base;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;

import jdk.nashorn.internal.ir.ObjectNode;
import org.junit.Test;

public class TestEncode {

    @Test
    public void test1() {
        String redirectUri = null;
        try {
            redirectUri = URLEncoder.encode("http://18851af1.cpolar.io/service-uaa/ajax.html&agentId=1000021", "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(redirectUri);
    }
}
