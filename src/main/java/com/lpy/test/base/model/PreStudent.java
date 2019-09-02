package com.lpy.test.base.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lipengyu
 * @date 2019/8/17 11:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreStudent extends Student{

    private String name;

    private Integer age;

    private Integer sex;
}

