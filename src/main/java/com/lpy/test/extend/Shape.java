package com.lpy.test.extend;

import java.util.Objects;

/**
 *  重写（override)又名覆盖:
 *      1.不能存在同一个类中，在继承或实现关系的类中；
 *      2. 名相同，参数列表相同，方法返回值相同，
 *      3.子类方法的访问修饰符要大于父类的。
 *      4.子类的检查异常类型要小于父类的检查异常。
 *  重载（overload）:
 *      1.可以在一个类中也可以在继承关系的类中；
 *      2.名相同；
 *      3.参数列表不同（个数，顺序，类型） 和方法的返回值类型无关。
 * ---------------------
 *
 * @author lipengyu
 * @date 2019/8/13 17:35
 */
class Shape {

    private Shape wf;

    protected Shape() {
        wf = this;
    }

    private int length() {
        return 0;
    }

    private int width() {
        return 0;
    }

    public static int out() {
        return 50;
    }

    public int getArea() {
        System.out.println(wf.length());
        System.out.println(wf.width());
        return wf.length()*wf.width();
    }

    public void go(int i) {
        System.out.println("parent go");
        goString(String.valueOf(i));
    }

    public void goString(String s) {
        System.out.println("parent goString: " + s);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(wf, shape.wf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wf);
    }
}
