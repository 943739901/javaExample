package com.lpy.test.base.extend;

/**
 * @author lipengyu
 * @date 2019/8/13 17:35
 */
public class OverridingShape extends Shape {

    private int radian;

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

    public int getRadian() {
        return radian;
    }

    public void setRadian(int radian) {
        this.radian = radian;
    }

    @Override
    public String toString() {
        return "OverridingShape{" +
                "radian=" + radian +
                '}';
    }
}

