package com.lpy.test.base;

import com.lpy.test.base.model.Person;
import org.junit.Test;

import java.util.*;

/**
 * Comparator和Comparable:
 *
 * Comparable
 * 它是一个排序接口，只包含一个函数compareTo()。
 * 一个类实现了Comparable接口，就意味着“该类本身支持排序”，它可以直接通过Arrays.sort() 或 Collections.sort()进行排序。
 *
 * Comparator
 * 它是一个比较器接口，包括两个函数：compare() 和 equals()。
 * 一个类实现了Comparator接口，那么它就是一个“比较器”。其它的类，可以根据该比较器去排序。
 *
 * 综上所述：Comparable是内部比较器，而Comparator是外部比较器。
 * 一个类本身实现了Comparable比较器，就意味着它本身支持排序；若它本身没实现Comparable，也可以通过外部比较器Comparator进行排序。
 *
 * @author lipengyu
 * @date 2019/8/17 9:30
 */
public class TestCompare {

    @Test
    public void test1() {

        // 新建ArrayList(动态数组)
        List<Person> list = Arrays.asList(
            new Person("ccc", 20),
            new Person("AAA", 30),
            new Person("bbb", 10),
            new Person("ddd", 40)
        );

        //Arrays.asList 创建的ArrayList是Arrays的内部类，并没有实现add，remove方法，直接调用了
        //java.util.AbstractList.add(int, E)
        //所以会报java.lang.UnsupportedOperationException
//        list.add(new Person("ddd", 40));

        // 添加对象到ArrayList中

        // 打印list的原始序列
        System.out.printf("Original  sort, list:%s\n", list);

        // 对list进行排序
        // 这里会根据“Person实现的Comparable<String>接口”进行排序，即会根据“name”进行排序
        Collections.sort(list);
        System.out.printf("Name      sort, list:%s\n", list);

        // 通过lambda表达式，可以不用实现Comparator
        // 根据“age”的升序排序
        list.sort(Comparator.comparingInt(Person::getAge));
        System.out.printf("Asc(age)  sort, list:%s\n", list);

        // 根据“age”的降序排序
        list.sort((o1, o2) -> o2.getAge() - o1.getAge());
        System.out.printf("Desc(age) sort, list:%s\n", list);
    }
}
