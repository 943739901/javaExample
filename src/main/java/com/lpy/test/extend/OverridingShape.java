package com.lpy.test.extend;

/**
 * @author lipengyu
 * @date 2019/8/13 17:35
 */
public class OverridingShape extends Shape {

    public int length() {
        return 10;
    }

//    @Override
    public int width() {
        return 10;
    }
//    @Override
    public static int out() {
        return 100;
    }

    public void go(int i) {
        System.out.println("son go");
        super.go(i);
    }

    public void goString(String s) {
        System.out.println("son goString: " + s);
        super.goString(s);
    }
}

