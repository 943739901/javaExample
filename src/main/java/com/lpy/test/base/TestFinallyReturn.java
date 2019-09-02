package com.lpy.test.base;

import org.junit.Test;

/**
 * try catch finally
 * 在try 中return 之前会执行finally 中的代码，如果finally 中有return 则直接return,值为finally 中修改的;
 * 如果finally 中没有return, 则执行try 中return， 数值仍然是try 中的
 *
 * finally 一定会被执行，如果 finally 里有 return 语句，则覆盖 try/catch 里的 return ，
 * 比较爱考的是 finally 里没有 return 语句，这时虽然 finally 里对 return 的值进行了
 * 修改，但 return 的值并不改变这种情况
 *
 * @author lipengyu
 * @date 2019/8/16 17:14
 */
public class TestFinallyReturn {
    
    @Test
    public void test1() {
        System.out.println(finallyReturn1());
        System.out.println(finallyReturn2());
        System.out.println(finallyReturn3());
    }

    /**
     * 先执行finally中的代码，然后执行try中的return;
     * @return
     */
    private int finallyReturn1() {
        int i = 0;
        try {
            i += 1;
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
        return 0;
    }

    /**
     * 执行finally中的代码，直接return， 值为在finally中修改的
     * @return
     */
    private int finallyReturn2() {
        int i = 0;
        try {
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
            i += 1;
            return i;
        }
    }

    /**
     * 执行finally中的代码，尽管在finally中值被修改了，但return的值不会改变
     *
     * @return
     */
    private int finallyReturn3() {
        int i = 1;
        try {
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
            i += 1;
        }
        return 0;
    }
}
