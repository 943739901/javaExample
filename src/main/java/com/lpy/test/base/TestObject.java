package com.lpy.test.base;

/**
 * Object:
 *  chone()
 *  equals(Object)
 *  finalize()
 *  getClass()
 *  hashCode()
 *  notify()
 *  notufyAll()
 *  registerNatives()
 *  toString()
 *  wait()
 *  wait(long)
 *  wait(long,int)
 *
 *
 * finalize:
 *
 *  垃圾回收器(garbage colector)决定回收某对象时，就会运行该对象的 finalize()方
 *  法 但是在 Java 中很不幸，如果内存总是充足的，那么垃圾回收可能永远不会进行，也就
 *  是说 filalize()可能永远不被执行，显然指望它做收尾工作是靠不住的。 那么 finalize()究竟
 *  是做什么的呢？它最主要的用途是回收特殊渠道申请的内存。Java 程序有垃圾回收器，所
 *  以一般情况下内存问题不用程序员操心。但有一种JNI(Java Native Interface)调用non-Java
 *  程序（C 或 C++），finalize()的工作就是回收这部分的内存。
 *
 * @author lipengyu
 * @date 2019/8/16 17:25
 */
public class TestObject {
}
