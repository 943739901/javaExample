package com.lpy.test.base;

import com.lpy.test.base.util.DateUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestTime2 {

    /**
     * token过期为7天，获取过期时间-当前时间-一天时间剩余的秒数
     */
    @Test
    public void test1() {
        long expireAtTime = 1608882502143L;
        long expireTime = (DateUtil.datetimeToTimestamp(DateUtil.timestampToDatetime(expireAtTime).minusDays(1)) - DateUtil.datetimeToTimestamp(LocalDateTime.now()))/1000;
        System.out.println(expireTime);
    }

    /**
     * token过期为7天，获取过期时间-当前时间-一天时间剩余的秒数
     */
    @Test
    public void test2() {
        Date date = new Date();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("0 mm HH * * ?");
        System.out.println(formatter.format(DateUtil.toLocalDateTime(date)));

    }


}
