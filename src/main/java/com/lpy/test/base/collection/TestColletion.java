package com.lpy.test.base.collection;

import com.lpy.test.base.model.Person;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lipengyu
 * @date 2019/8/22 10:49
 */
public class TestColletion {

    @Test
    public void test1() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("ccc", 20));
        list.add(new Person("AAA", 30));
        list.add(new Person("bbb", 10));
        list.add(new Person(null, 20));
//


        List<Person> collect = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getAge))), ArrayList::new));
        collect.forEach(System.out::println);


//
//        List<String> collect = list.stream().map(Person::getName).collect(Collectors.toList());
//        collect.forEach(System.out::println);


//        List<Integer> collect = list.stream().map(Person::getAge).distinct().collect(Collectors.toList());
//        collect.forEach(System.out::println);
//        List<String> list1 = new ArrayList<>();
//        list1.add("ddd");
//        list1.add("ccc");
//        list1.add("aaa");
//        list1.add("bbb");
//
//        for (String s : list) {
//            if ("ccc".equals(s)) {
//                list.remove(s);
//            }
//        }

//        Object o = null;
//
//        int i = (int)o;
//        System.out.println(i);

//        for (int i = 0; i < list.size(); i++) {
//            list.get(i) = null;
//        }

//        for (String s : list) {
//            s = "a";
//        }
//        list.forEach(System.out::println);

//        list.removeIf("ccc"::equals);
    }
}
