package com.lpy.test.base.model;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author lipengyu
 * @date 2019/8/16 14:27
 */
@Data
@AllArgsConstructor
public class Person implements Comparable<Person> {

    private String name;
    private Integer age;

    /**
     * 实现 “Comparable<String>” 的接口，即重写compareTo<T t>函数。
     * 这里是通过“person的名字”进行比较的
     */
    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }
}
