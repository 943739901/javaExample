package com.lpy.test.base;

import org.junit.Test;

/**
 * String , StringBuffer,  StringBuilder
 *
 * 相同和区别：
 *
 *  1. 都是final类，都不允许被继承
 *  2. String的长度是不可变的，StringBuffer、StringBuilder长度是可变的
 *  3. StringBuffer是线程安全的，StringBuilder不是线程安全的，但他们中的所有方法是相同的，
 *     StringBuffer在StringBuilder的方法之上添加了syncronized修饰，保证线程安全
 *     部分没加的要么是直接调用，要么是通过多态调用已经加的方法。
 *  4. StringBuilder比StringBuffer拥有更好的性能
 *  5. 如果一个String类型的字符串，在编译时就可以确定是一个字符串常量，则编译完成之后，字符串会自动拼接成一个常量。
 *     此时String的速度比StringBffer和StringBuilder的性能好的多。
 *
 *
 * String不可变的理解：
 *
 *  1. String类是被final进行修饰的，不能被继承。
 *  2. 在用 + 号连接字符串的时候会创建新的字符串。
 *  3. String s = new String("Hello World"); 可能创建两个对象也可能创建一个对象。
 *     如果静态区中有"Hello World"字符串常量对象的话， 则仅仅在堆中创建一个对象。
 *     如果静态区中没有"Hello World"对象, 则堆上和静态区中都需要创建对象。
 *  4. 在java中，通过使用 + 符号来串联字符串的时候，实际上底层会转成通过StringBuilder实例的append()方法来实现。
 *
 *
 * 构造相同hash的字符串进行攻击，这种情况应该怎么处理？JDK7如何处理？ ##粗浅的看了一下##
 * https://blog.csdn.net/calledwww/article/details/79306594
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

    @Test
    public void test2() {
        StringBuilder sb = new StringBuilder();
        sb.append("root").append(",").append("123456");
        System.out.println(sb.toString());
        String s = "李鹏宇,";
        sb.insert(0, s);
        System.out.println(sb.toString());
        sb.delete(0, s.length());
        System.out.println(sb.toString());
    }

    @Test
    public void test3() {
        String instanceId = "shencom-1";
        Integer integer = 0;
        char c = (char) (integer + 65);
        System.out.println(instanceId + "-" + c);
    }
}



















































