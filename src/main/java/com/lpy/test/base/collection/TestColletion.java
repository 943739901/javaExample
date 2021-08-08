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


//        List<Person> collect = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getAge))), ArrayList::new));
//        List<String> collect = list.stream().map(Person::getName).collect(Collectors.toList());
//        collect.forEach(System.out::println);


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

//        String s = "1";
//        Map<String, Person> map = new HashMap<>();
//        map.put(s, new Person("ccc", 20));
//        System.out.println(map);

        Person p = new Person("ccc", 20);

        String name = p.getName();
        p.setName("111");
        System.out.println(name);

//
//        Map<Person, Person> map1 = new HashMap<>();
//        map1.put(p, p);
//        p.setName("aaaaaaa");
//
//        System.out.println(map1);

    }


    @Test
    public void test2() {
        List<String> oldRegionCids = new ArrayList<>();
        oldRegionCids.add("A");
        oldRegionCids.add("B");
        oldRegionCids.add("C");

        List<String> newRegionCids = new ArrayList<>();
//        newRegionCids.add("A");
//        newRegionCids.add("C");
//        newRegionCids.add("D");

        List<String> intersection = oldRegionCids.stream().filter(newRegionCids::contains).collect(Collectors.toList());
        intersection.forEach(System.out::println);

        oldRegionCids.removeAll(intersection);

        newRegionCids.removeAll(intersection);

        System.out.println("-------------------------");

        oldRegionCids.forEach(System.out::println);

        System.out.println("-------------------------");

        newRegionCids.forEach(System.out::println);
    }

    @Test
    public void test3() {
        List<String> s1 = new ArrayList<>(Arrays.asList("a","b","c"));
        List<String> s2 = new ArrayList<>(Arrays.asList("b","c","d"));
        List<String> s3 = new ArrayList<>(Arrays.asList("c","d","e"));

        s1.addAll(s2);
        s1.addAll(s3);

        System.out.println(s1);
    }

    @Test
    public void test4() {

        int[] elementData = new int[10];

        elementData[0] = 1;
        elementData[1] = 2;
        elementData[2] = 3;
        elementData[3] = 4;
        elementData[4] = 5;

        System.arraycopy(elementData, 2, elementData, 2 + 1, 9 - 2);
//        elementData[2] = 100;

        for (int elementDatum : elementData) {
            System.out.println(elementDatum);
        }

//        int n = 16;
//        System.out.println(n>>>2);
//        n|=n>>>1;
//
////        n = n | n>>>1;
//
//        n|=n>>>2;
//        n|=n>>>4;
//        n|=n>>>8;
//        n|=n>>>16;
//        System.out.println(n);

//        String filename = "filename.xls";

//        System.out.println(filename.substring(0,filename.lastIndexOf(".")));

//        String fileUrl = "https://filesvr-shencom-cn.oss-cn-shenzhen.aliyuncs.com/gov_sc/files/1083189256325484544.xls";
//
//        String file = fileUrl.substring(fileUrl.lastIndexOf("/")+1);
//        System.out.println(file);
//

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
        System.out.println(objects.size());
    }


}






























