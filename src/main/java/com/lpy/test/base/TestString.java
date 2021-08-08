package com.lpy.test.base;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    /**
     * 过滤字符串中的转义字符
     */
    @Test
    public void test4() {
        String str = "         胡永聪、     \n\t         胡永聪       ";
        System.out.println(str);
        System.out.println("-------------------");
        System.out.println(StringUtils.removePattern(str, "\\s*|\t|\r|\n"));
        System.out.println("-------------------");
    }

    /**
     * list转string根据字符隔开
     */
    @Test
    public void test5() {
        List<String> cities = Arrays.asList("Milan", "London", "New York", "San Francisco");
        String citiesCommaSeparated = String.join(",", cities);
        System.out.println(citiesCommaSeparated);
        String collect = cities.stream().collect(Collectors.joining("、", "[", "]"));
        System.out.println(collect);
    }

    /**
     * String转list根据字符隔开
     */
    @Test
    public void test6() {
        String cities = "Milan,London,New York,San Francisco";
        List<String> cityList = Stream.of(cities.split(",")).collect(Collectors.toList());
        cityList.forEach(System.out::println);
    }

    /**
     * parseInt过滤字符串多余0
     */
    @Test
    public void test7() {
        String str = "00010";
        System.out.println(Integer.parseInt(str));


        String latestTaskNo = "00000";
        System.out.println("DC" + String.format("%05d", Integer.parseInt(latestTaskNo) + 1));
    }

    @Test
    public void test8() {
        String str = "sc_clazz";
        String replace = str.replace("_", "/");
        System.out.println(replace);
    }

    @Test
    public void test9() {
        String s = "ST1115861394283286528";
        System.out.println(s.startsWith("ST"));
    }

    /**
     * 实际上各种文章上说flatmap把数据变扁平化 实际上就像下面这个例子
     * 将单个字符串转化为Stream<String[]>，再转化为Stream<String>
     *
     *     [hello c++] [hello java] [hello python]
     * ->   hello c++ hello java hello python
     */
    @Test
    public void test10() {
        // 将集合中的字符串中单词提取出来，不考虑特殊字符
        List<String> words = Arrays.asList("hello c++", "hello java", "hello python");
        List<String> result = words.stream()
                // 将单词按照空格切合，返回Stream<String[]>类型的数据
                .map(word -> word.split(" "))
                // 将Stream<String[]>转换为Stream<String>
                .flatMap(Arrays::stream)
                // 去重
                .distinct()
                .collect(Collectors.toList());
        System.out.println(result);

    }
}



















































