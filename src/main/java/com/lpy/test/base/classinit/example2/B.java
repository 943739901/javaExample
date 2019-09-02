package com.lpy.test.base.classinit.example2;

/**
 * 输出0000时需要加载B类和A类，且A类中有a才会执行构造块和构造方法，后面都不执行是因为没有new 对象
 *
 * @author lipengyu
 * @date 2019/8/15 10:26
 */
class A {
    private static A a=new A();
    public A(){
        System.out.println("A构造方法 ");
    }
    static{
        System.out.println("A静态初始化块 ");
    }
    {
        System.out.println("A初始化块 ");
    }
}
public class B extends A {
    public B(){
        System.out.println("B构造方法");
    }

    public static void main(String[] args) {
        System.out.println("0000");
        // 此时private static A a=new A();已初始化完毕，new B()时不会再初始化。
        B b=new B();
    }
}



