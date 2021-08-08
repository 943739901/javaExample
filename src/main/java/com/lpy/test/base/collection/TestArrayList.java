package com.lpy.test.base.collection;

import com.lpy.test.base.model.Person;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lipengyu
 */
public class TestArrayList {

    /**
     * 交集
     */
    @Test
    public void test1() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("ccc", 20));
        list.add(new Person("AAA", 30));
        list.add(new Person("bbb", 10));
        list.add(new Person(null, 20));

        List<String> strings1 = new ArrayList<>(Arrays.asList("lastProcessContent", "processContent", "orgnizerName"
                , "statusAppraisalName", "plan", "aaa"));

        List<String> strings = new ArrayList<>(Arrays.asList("msgNo", "msg", "name", "resourceName", "goal", "content", "startTime", "endTime"
                , "departmentName", "managerName", "extOrgName", "extUserName", "orgnizerName", "processContent", "plan"
                , "statusAppraisalName", "lastProcessContent"));

//        strings.retainAll(strings1);
//        System.out.println(strings);

        Collection<String> strings2 = CollectionUtils.retainAll(strings1, strings);

        System.out.println(strings2);
        System.out.println(strings);
        System.out.println(strings1);

//        Collections.reverse(list);
//        System.out.println(list);

    }

    /**
     * 工作时间: 每周 1234567 不能重复
     * 如果已有数据   每周 2,3,4 后面新增就不能有 2 3 4 了
     */
    @Test
    public void test2() {
        List<String> list = new ArrayList<>();
        list.add("1,2");
        list.add("4,6");
        list.add("3");

        String param = "2,4,5";

        List<String> exsit = Arrays.stream(String.join(",", list).split(",")).distinct().collect(Collectors.toList());
        List<String> save = Arrays.asList(param.split(","));

        System.out.println(exsit);
        System.out.println(save);

        save.forEach(re -> {
            if (exsit.contains(re)) {
            }
        });

    }


    /**
     *
     * 是否可以反复sublist
     */
    @Test
    public void test3() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        String s = "1.2.3";


        int i = StringUtils.countMatches(s, ",");
        System.out.println(i);

        System.out.println(s.substring(0, StringUtils.ordinalIndexOf(s, ".", 1)));
        System.out.println(s.substring(0, StringUtils.ordinalIndexOf(s, ".", 2)));
//        System.out.println(s.substring(0, StringUtils.ordinalIndexOf(s, ".", 3)));


//        System.out.println(list);
    }

}
