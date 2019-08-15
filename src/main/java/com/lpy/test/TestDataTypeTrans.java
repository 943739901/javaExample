package com.lpy.test;

import org.junit.Test;

/**
 * 数据类型转换
 *
 * @author lipengyu
 * @date 2019/8/13 10:02
 */
public class TestDataTypeTrans {

    /**
     * short s1 = 1; s1 = s1 + 1;有什么错? short s1 = 1; s1 +=1;有什么错?
     *
     * 对于short s1=1;s1=s1+1来说，在s1+1运算时会自动提升表达式的类型为int，那么将int赋予给short类型的变量s1会出现类型转换错误。
     * 对于short s1=1;s1+=1来说 +=是java语言规定的运算符，java编译器会对它进行特殊处理，因此可以正确编译。
     */
    @Test
    public void test1() {
        short i = 1;
//        i = i + 1;
        i += 1;
        System.out.println(i);
    }

    /**
     * String 转 int
     */
    @Test
    public void test2() {
        String A = "a";
        String B = null;
        String C = "1";
        String D = "2147483648";

        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        long l = 0;
        try {
            a = Integer.parseInt(A);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            b = Integer.parseInt(B);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            c = Integer.parseInt(C);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            d = Integer.parseInt(D);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            l = Long.parseLong(D);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(l);
    }





























































}
