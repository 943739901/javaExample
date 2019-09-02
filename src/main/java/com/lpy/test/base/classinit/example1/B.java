package com.lpy.test.base.classinit.example1;

/**
 *
 * 为什么当前类静态成员变量是当前类型时不会stackoverflow？（没有static是会的）
 *
 * 因为静态初始化块和成员变量只会初始化一次，
 * 在执行初始化a时，会直接执行该成员变量的成员赋值和构造块，不会执行该成员变量内部的静态成员和静态块
 * （猜测是因为jvm认为已经在执行的过程中了，不会再初始化）
 */
class A {
    static {
        System.out.println("static ");
    }

    public static A a = new A();

    public A() {
        System.out.println("A ");
    }

    {
        System.out.println("C");
    }
}

public class B extends A {
    public B() {
        System.out.print("B ");
    }

    public static void main(String[] args) {
        B b = new B();
    }

}