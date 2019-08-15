package com.lpy.test;

import org.junit.Test;

import java.io.*;

/**
 * String , StringBuffer,  StringBuilder
 *
 * 相同和区别：
 *
 *  1. 都是final类，都不允许被继承
 *  2. String的长度是不可变的，StringBuffer、StringBuilder长度是可变的
 *  3. StringBuffer是线程安全的，StringBuilder不是线程安全的，但他们中的所有方法是相同的，
 *     StringBuffer在StringBuilder的方法之上添加了syncronized修饰，保证线程安全
 *  4. StringBuilder比StringBuffer拥有更好的性能
 *  5. 如果一个String类型的字符串，在编译时就可以确定是一个字符串常量，则编译完成之后，字符串会自动拼接成一个常量。
 *     此时String的速度比StringBffer和StringBuilder的性能好的多。
 *
 *
 *
 * @author lipengyu
 * @date 2019/8/14 16:27
 */
public class TestString {

    /**
     * 为什么要复写equals()的同时最好复写hashcode()
     * https://772755318.iteye.com/blog/2070614
     */
    @Test
    public void test1() {
        String s = new String("aaa");
        System.out.println(s.hashCode());
    }
}
