package com.lpy.test.base;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.Test;

public class TestTime {

    @Test
    public void test1() {
        String timestamp = String.valueOf(Instant.now().toEpochMilli());
        System.out.println(timestamp);

        LocalDateTime startDate = LocalDateTime.parse("2019-07-12T13:33:12.294Z", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
        System.out.println(startDate);
    }

    @Test
    public void test2() {
        Date date = new Date();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date1 = new Date();
        System.out.println(date.after(date1));
    }
}
