package com.lpy.test.base;

import org.junit.Test;

/**
 * 装箱拆箱
 *
 *  包含cache的数据类型有
 *  IntegerCache : [-128, 127]
 *
 *  LongCache : [-128, 127]
 *
 *  ShortCache : [-128, 127]
 *
 *  ByteCache : [-128, 127]
 *
 *  CharacterCache : [0, 127]
 *
 * @author lipengyu
 * @date 2019/8/13 10:02
 */
public class TestBoxing {

    /**
     * Integer 和 Long 类型的euqals都一样，如果不是本类型，都返回false
     * @see java.lang.Long#equals(java.lang.Object)
     * @see java.lang.Integer#equals(java.lang.Object)
     */
    @Test
    public void test1() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 128;
        Integer f = 128;
        Long g = 3L;
        Long h = 2L;
        System.out.println(c==d);//true 比较cache
        System.out.println(e==f);//false 比较引用
        System.out.println(c==(a+b));//true 比较值
        System.out.println(c.equals(a+b));//true 比较值
        System.out.println(g==(a+b));//true //比较值
        System.out.println(g.equals(a+b));//false //比较引用(对于包装器类型，equals方法并不会进行类型转换)
        System.out.println(g.equals(a+h));//true比较引用
    }

//    java语句Integeri=1;i+=1;做了哪些事情？
//    首先 Integer i = 1; 做了自动装箱（使用 Integer.valueOf() 方法将 int 装箱为 Integer 类型），接着 i += 1; 先将 Integer 类型的 i 自动拆箱成 int（使用Integer.intValue() 方法将 Integer 拆箱为 int），完成加法运行之后的 i 再装箱成 Integer 类型。


    /**
     * new Integer(xxx)这种创建对象的方法不是自动装箱，没有用到cache,因此i1 == i2是false。
     *
     * java在编译Integer i = 100时，会翻译成为Integer i = Integer.valueOf(100)， 就会返回缓存的数据
     */
    @Test
    public void test2() {
        Integer i1 = new Integer(127);
        Integer i2 = new Integer(127);
        Integer i3 = 127;
        System.out.println(i1 == i2);//false
        System.out.println(i1.equals(i2));//true
        System.out.println(i1 == i3);//false 常量池和堆中对象的内存不同
        System.out.println(i1.equals(i3));//true
    }

//      谈谈Integer i = new Integer(xxx)和Integer i =xxx;这两种方式的区别。
//     　1）第一种方式不会触发自动装箱的过程；而第二种方式会触发。
//     　2）在执行效率和资源占用上的区别。第二种方式的执行效率和资源占用在一般性情况下要优于第一种情况（注意这并不是绝对的）。

    /**
     * char 的范围是0~65535
     */
    @Test
    public void test3() {
//        不允许赋值为负
//        Character i1 = -1;
    }



























}
