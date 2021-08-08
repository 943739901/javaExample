package com.lpy.test.base.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestSet {

    @Test
    public void test() {
        String names1 = "大、中、小、超小";
        String names2 = "大、中、小、超大";

        Set<String> names = new HashSet<>();
        names.addAll(Arrays.asList(names1.split("、")));
        names.addAll(Arrays.asList(names2.split("、")));
        System.out.println(names);
    }
}
