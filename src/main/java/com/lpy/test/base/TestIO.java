package com.lpy.test.base;

import org.junit.Test;

import java.io.*;

/**
 * io流
 *
 * @author lipengyu
 * @date 2019/8/15 16:58
 */
public class TestIO {

    /**
     * 面经中的例子
     */
    @Test
    public void test1() {
        File file = new File("/aaa.txt");
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
            String s = br.readLine();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
