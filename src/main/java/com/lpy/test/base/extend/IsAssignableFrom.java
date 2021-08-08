package com.lpy.test.base.extend;

class A {
}

class B extends A {
}

class C extends A {
}


public class IsAssignableFrom {
    public static void main(String[] args) {
        System.out.println(B.class.isAssignableFrom(C.class));
    }
}
