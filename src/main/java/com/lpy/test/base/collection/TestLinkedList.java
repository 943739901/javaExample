package com.lpy.test.base.collection;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lipengyu
 * @date 2021/7/17 0:49
 */
public class TestLinkedList {

    /**
     *
     * 测试插入
     */
    @Test
    public void test() {
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        list.addFirst("0");
        list.add(1, "2");






        System.out.println(list);
    }
}
