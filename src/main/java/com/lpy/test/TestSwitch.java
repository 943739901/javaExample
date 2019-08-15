package com.lpy.test;

import org.junit.Test;

/**
 * switch 用法
 *
 * @author lipengyu
 * @date 2019/8/13 14:26
 */
public class TestSwitch {

    /**
     * 截止到jdk1.8 switch支持如下数据类型
     *
     * char, byte, short, int, Character, Byte, Short, Integer, String, or an enum
     */
    @Test
    public void test1() {
//        long i = 1;
        String s = "teacher";
        switch (s) {
            case "student":
                System.out.println(1);
                break;
            case "teacher":
                System.out.println(2);
                break;
            case "parent":
                System.out.println(3);
                break;
            default:
                System.out.println(4);
        }
    }
}
