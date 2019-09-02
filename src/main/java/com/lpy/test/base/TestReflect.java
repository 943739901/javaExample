package com.lpy.test.base;

import com.lpy.test.base.model.Person;
import org.junit.Test;

/**
 * 反射:
 *
 *  JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；
 *  对于任意一个对象，都能够调用它的任意方法和属性；
 *  这种动态获取信息以及动态调用对象方法的功能称为java语言的反射机制。
 *
 *  Class.forName("")得到的class是已经初始化完成的,会执行类中的静态初始化块
 *  classLoader.loadClass("")得到的class只会装载和连接的,只有在newInstance()才会执行类中的静态初始化块
 *
 * @author lipengyu
 * @date 2019/8/15 17:12
 */
public class TestReflect {

    @Test
    public void test1() {
        try {
            Class<?> aClass = Class.forName("com.lpy.test.base.model.Person");
            Object o = aClass.newInstance();
            Person person = (Person) o;
            System.out.println(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            Class<?> aClass = classLoader.loadClass("com.lpy.test.base.model.Person");
            Object o = aClass.newInstance();
            Person person = (Person) o;
            System.out.println(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
