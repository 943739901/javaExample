package com.lpy.test.base;

import com.lpy.test.base.model.PreStudent;
import com.lpy.test.base.model.Student;
import com.lpy.test.base.model.Teacher;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 泛型中占位符T和?有什么区别？
 * https://blog.csdn.net/woshizisezise/article/details/79374460
 *
 * @author lipengyu
 * @date 2019/8/17 11:11
 */
public class TestGenerics {

    @Test
    public void test1() {
        List list1 = Arrays.asList(
                new Student("zhangsan", 18, 0),
                new Student("lisi", 28, 0),
                new Student("wangwu", 24, 1)
        );

        //这里如果add(new Teacher(...);就会报错，因为我们已经给List指定了数据类型为Student
        show1(list1);
    }

    @Test
    public void test2() {
        //这里我们并没有给List指定具体的数据类型，可以存放多种类型数据
        List list2 = Arrays.asList(
                new Student("zhaoliu", 22, 1),
                new Teacher("sunba", 30, 0)
        );
        show2(list2);
    }

    @Test
    public void test3() {
        List<Teacher> list3 = Arrays.asList(
                new Student("zhaoliu", 22, 1),
                new Teacher("sunba", 30, 0)
        );

        // list中对象的类型只能是Teacher和它的子类
        // 若改为List<? extends Student Teacher不是Student的子类 则会报错
        // 注意: 这里要指定Teacher的类型才会报错
        show3(list3);
    }

    @Test
    public void test4() {
        List list4 = Arrays.asList(
                new Student("sunba", 30, 0),
                new Teacher("zhaoliu", 22, 1)
        );
        // list中对象的类型只能是Student和它的父类
        show4(list4);

        List<PreStudent> list5 = Arrays.asList(
                new PreStudent("sunba", 30, 0),
                new PreStudent("zhaoliu", 22, 1)
        );
        // 因为PreStudent是Student的子类，且list指定了类型，所以会报错
//        show4(list5);
    }

    /**
     * 如果不限制类型，无论如何改变T 或者 ? 都可以正常输出
     *
     * 因为不限制类型，编译时和运行时就无法判断参数是否符合规则，
     * 能够正常输出，是因为多态，相当于
     * Object object = new PreStudent("zhangsan", 30, 0);
     * 当然调用的toString()是子类的
     */
    @Test
    public void test5() {
        List list5 = Arrays.asList(
                new PreStudent("zhangsan", 30, 0),
                new Student("sunba", 30, 0),
                new Teacher("zhaoliu", 22, 1)
        );
        show4(list5);
    }


    public <T> void show1(List<T> list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }

    public void show2(List<?> list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }

    public void show3(List<? extends Teacher> list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }

    public void show4(List<? extends Teacher> list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }
}
