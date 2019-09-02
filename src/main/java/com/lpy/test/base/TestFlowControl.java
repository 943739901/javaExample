package com.lpy.test.base;

import org.junit.Test;

/**
 * 流程控制
 *
 * @author lipengyu
 * @date 2019/8/13 14:26
 */
public class TestFlowControl {

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


    /**
     * assert 用法
     */
    @Test
    public void test2() {
        //断言1结果为true，则继续往下执行
        assert true;
        System.out.println("断言1没有问题，Go！");

        System.out.println("\n-----------------\n");

        //断言2结果为false,程序终止
        assert false : "断言失败，此表达式的信息将会在抛出异常的时候输出！";
        System.out.println("断言2没有问题，Go！");
    }
}
