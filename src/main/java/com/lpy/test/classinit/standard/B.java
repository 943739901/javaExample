package com.lpy.test.classinit.standard;

/**
 * 1、父类的静态成员和静态块
 * 2、子类的静态成员和静态块
 * 3、父类的成员赋值和构造块
 * 4、父类的构造方法
 * 5、子类的成员赋值和构造块
 * 6、子类的构造方法
 *
 * 注意：
 *      1. 静态初始化块和成员变量只会初始化一次
 *      2. 静态成员和静态块
 *         普通成员和构造块
 *         谁在前面谁就先初始化
 *
 * 特殊情况：当该类的成员变量的类型是该类，如A类有成员变量static A a = new A(); （需要是静态的，否则会报StackOverFlow）
 * 则在执行初始化静态成员变量a时，直接执行该成员变量的成员赋值和构造块，不会执行该成员变量内部的静态成员和静态块（猜测是因为静态初始化块和成员变量只会初始化一次，jvm认为已经在执行的过程中了，不会再初始化），
 * 当该成员变量初始化结束后，继续按照上述步骤执行
 *
 * @author lipengyu
 * @date 2019/8/15 10:26
 */
class D {
    public D() {
        System.out.println("D ");
    }
}

class C {
    public C() {
        System.out.println("C ");
    }
}

class A {
    private static A a = new A();
    private C c = new C();

    public A() {
        System.out.println("A gouzhao ");
    }

    static {
        System.out.println("static A ");
    }

    {
        System.out.println("A1 ");
    }
}

public class B extends A {
    private static D d = new D();
    private C c = new C();

    public B() {
        System.out.println("B ");
    }

    static {
        System.out.println("static B ");
    }

    {
        System.out.println("B1 ");
    }

    public static void main(String[] args) {
        B b = new B();
    }
}
