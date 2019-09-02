package com.lpy.test.base.extend;

import org.junit.Test;

/**
 * Java 中 static 方法不能被覆盖，因为方法覆盖是基于运行时动态绑定的，而 static 方法
 * 是编译时静态绑定的。static 方法跟类的任何实例都不相关，所以概念上不适用。
 * java 中也不可以覆盖 private 的方法，因为 private 修饰的变量和方法只能在当前类中使用，
 * 如果是其他的类继承当前类是不能访问到 private 变量或方法的，当然也不能覆盖。
 *
 * @author lipengyu
 * @date 2019/8/13 17:54
 */
public class TestExtend {

    @Test
    public void test1() {
        Shape s = new OverridingShape();
        System.out.println(s.getArea());
        System.out.println(s.out());
        System.out.println(OverridingShape.out());
    }

    /**
     * 验证多态调用方法顺序：
     *
     * son go
     * parent go
     * son goString: 1
     * parent goString: 1
     *
     * StringBuffer 和 StringBuilder 的区别就是在于StringBuffer几乎所有的方法都加了 synchronized
     *
     * 没加的要么是直接调用，要么是通过多态调用已经加的方法。
     *
     * @see StringBuffer#insert(int, int)
     * @see AbstractStringBuilder#insert(int, int)
     * @see StringBuffer#insert(int, java.lang.String)
     * @see AbstractStringBuilder#insert(int, java.lang.String)
     *
     *
     *
     */
    @Test
    public void test2() {
        Shape s = new OverridingShape();
        s.go(1);
    }

    @Test
    public void test3() {
        OverridingShape overridingShape = new OverridingShape();
        overridingShape.setRadian(1);
        Shape s = overridingShape;
        System.out.println(s);
    }
}
