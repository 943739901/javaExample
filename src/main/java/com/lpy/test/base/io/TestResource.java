package com.lpy.test.base.io;

import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;

/**
 * @author lipengyu
 * @date 2019/9/17 9:53
 */
public class TestResource {

    @Test
    public void test() throws IOException, URISyntaxException {
//        Path rootLocation = Paths.get("a.txt");
//        if(Files.notExists(rootLocation)){
//            Files.createFile(rootLocation);
//        }
//        String a = "aaa";
//
//        byte[] strToBytes = a.getBytes();
//        Files.write(rootLocation, strToBytes);

        InputStream in = TestResource.class.getClassLoader().getResourceAsStream("a.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));


        String filePath = TestResource.class.getClassLoader().getResource("a.txt").toURI().getPath();

        BufferedReader br = null;
        BufferedWriter bw = null;

        // 从输入流中读取属性列表（键和元素对）
        br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

        // 写入属性文件
        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
        // 清空旧的文件
        bw.write("aaabbb");

        bw.close();
        br.close();



    }
}
