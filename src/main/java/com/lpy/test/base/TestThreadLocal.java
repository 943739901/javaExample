package com.lpy.test.base;

import org.junit.Test;

/**
 * threadlocal
 * https://www.cnblogs.com/noteless/p/10373044.html
 *
 * 可以定义多个ThreadLocal变量存入threadLocals中
 *
 * @author lipengyu
 * @date 2019/8/16 16:03
 */
public class TestThreadLocal {
    //定义ThreadLocal变量
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    //设定初始值

    /**
     * 如果第一次调用时，指定线程并没有threadLocals，或者根本都没有进行过set，则会调用setInitialValue方法
     * 默认的是返回null的
     * @see java.lang.ThreadLocal#setInitialValue()
     * @see java.lang.ThreadLocal#initialValue()
     *
     * 内部类覆盖initialValue()方法
     * @see java.lang.ThreadLocal.SuppliedThreadLocal
     */
    static ThreadLocal<String> threadLocal1 = ThreadLocal.withInitial(() -> "init");

    @Test
    public void test1() {
        Thread thread1 = new Thread(() -> {
            //thread1中设置值
            threadLocal.set("this is thread1's local");
            //获取值
            System.out.println(Thread.currentThread().getName() + ": threadLocal value：" + threadLocal.get());
            //移除值
            threadLocal.remove();
            //再次获取
            System.out.println(Thread.currentThread().getName() + ": after remove threadLocal value：" + threadLocal.get());
        }, "thread1");
        Thread thread2 = new Thread(() -> {
            //thread2中设置值
            threadLocal.set("this is thread2's local");
            //获取值
            System.out.println(Thread.currentThread().getName() + ": threadLocal value：" + threadLocal.get());
            //移除值
            threadLocal.remove();
            //再次获取
            System.out.println(Thread.currentThread().getName() + ": after remove threadLocal value：" + threadLocal.get());
        }, "thread2");
        thread1.start();
        thread2.start();
    }
}
