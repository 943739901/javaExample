package com.lpy.test.base;

import java.math.BigDecimal;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lpy.test.base.util.DateUtil;
import org.junit.Test;

import com.lpy.test.base.util.BigDecimalUtil;


public class TestTime {

    @Test
    public void test1() {
        String second = String.valueOf(Instant.now().getEpochSecond());
        System.out.println(second);

        String milli = String.valueOf(Instant.now().toEpochMilli());
        System.out.println(milli);

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

    @Test
    public void test3() {
//        LocalDateTime startOf = LocalDateTime.of(startDate, LocalTime.MIN);
//        LocalDateTime endOf = LocalDateTime.of(endDate, LocalTime.MAX);

        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1);
        LocalDateTime localDateTime = LocalDateTime.now().minusDays(1);
        System.out.println(localDateTime);

        LocalDateTime localDateTime2 = LocalDateTime.of(2020, 1, 8, 12, 0, 0);
        System.out.println(localDateTime2);
        System.out.println(localDateTime2.isAfter(localDateTime) && localDateTime2.isBefore(localDateTime1));

        //  2020/01/08 00:00:00

        String format = localDateTime2.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
        System.out.println(format);
    }

    @Test
    public void test4() {
        boolean matches = Pattern.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$", "Ll123456");
        System.out.println(matches);
    }

    @Test
    public void test5() {
        Random random = new Random();
        System.out.println(random.nextInt(1000000));
    }

    @Test
    public void test6() {
        Date date = new Date();
        System.out.println(date);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(df.format(localDateTime));

        String s = replaceBlank("重点工作任务\n(30)分");
        System.out.println(s);
    }

    public String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    @Test
    public void test7() {
        LocalDateTime now = LocalDateTime.now();
        Instant nowInstant = now.atZone(ZoneId.systemDefault()).toInstant();
        LocalDateTime start = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(), now.getMinute());
        Instant startInstant = start.atZone(ZoneId.systemDefault()).toInstant();
        Date startDate = Date.from(startInstant);
        LocalDateTime end = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(), now.getMinute() + 1);
        Instant endInstant = end.atZone(ZoneId.systemDefault()).toInstant();
        Date endDate = Date.from(endInstant);

        System.out.println(startDate);
        System.out.println(endDate);
        System.out.println(nowInstant);
        System.out.println(startInstant);
        System.out.println(endInstant);
        System.out.println(nowInstant.compareTo(startInstant) >= 0 && nowInstant.compareTo(endInstant) < 0);
    }


    @Test
    public void test8() {
        BigDecimal a = new BigDecimal("10.11");
        BigDecimal b = new BigDecimal("10.12");
        BigDecimal div = BigDecimalUtil.div(a.doubleValue(), b.doubleValue());
        System.out.println(div);
    }


    @Test
    public void test9() {
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime localDateTime = now.minusMinutes(10);
//        System.out.println(isLongerthanMinute(toDate(localDateTime)));
//        System.out.println(isLongerthanMinute(toDate(now)));
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime createdAt = now.minusDays(1);
        System.out.println(createdAt);
    }

    @Test
    public void test10() throws InterruptedException {
        Instant now = Instant.now();
        LocalDateTime now1 = LocalDateTime.now();

        LocalDateTime of = LocalDateTime.of(2020, 7, 20, 17, 48, 3, 0);
//        Instant instant = of.atZone(ZoneId.systemDefault()).toInstant();
//
//        long used = ChronoUnit.MILLIS.between(instant, Instant.now());
//        long used1 = ChronoUnit.HOURS.between(instant, Instant.now());
//
//        //或者
//        //long used =now.until(Instant.now(), ChronoUnit.MILLIS)
//
//        System.out.println("business used " + used + " ms");
//        System.out.println("business used " + used1 + " hours");

        Date createdAt = DateUtil.toDate(of);
//        30486203
        LocalDateTime localDateTime = DateUtil.toLocalDateTime(createdAt).plusDays(1);
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        if (instant.isAfter(Instant.now())) {
            System.out.println(ChronoUnit.MILLIS.between(instant, Instant.now()));
        }


    }


    @Test
    public void test11() {
        LocalDate today = LocalDate.now();
        //本月的第一天
        LocalDate firstday = LocalDate.of(today.getYear(),today.getMonth(),1);
        //本月的最后一天
        LocalDate lastDay =today.with(TemporalAdjusters.lastDayOfMonth());

        LocalDateTime start = firstday.atStartOfDay();
        LocalDateTime end = lastDay.atTime(23, 59, 59);

        System.out.println(DateUtil.toDate(start));
        System.out.println(DateUtil.toDate(end));
    }

    @Test
    public void test12() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime now1 = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(), 59);
        LocalDateTime of = now1.plusMinutes(1);
        System.out.println(of);
    }

    @Test
    public void test13() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime of = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), now.getHour(), 0).plusHours(1);
        System.out.println(of.getDayOfWeek().getValue());
    }

    @Test
    public void test14() {
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime with = now.with(TemporalAdjusters.next(DayOfWeek.of(4)));
//        System.out.println(with);
//
//
//        System.out.println(now.with(TemporalAdjusters.previous(DayOfWeek.of(4)))
//                .withHour(18)
//                .withMinute(0)
//                .withSecond(0));
//
//
//        System.out.println(now.withDayOfMonth(15));

        LocalDate today = LocalDate.now();
        System.out.println(DateUtil.toDate(LocalDateTime.of(today, LocalTime.MIN)));
        System.out.println(DateUtil.toDate(LocalDateTime.of(today, LocalTime.MAX)));
    }


    public static boolean isLongerthanMinute(Date date){
        LocalDateTime localDateTime = DateUtil.toLocalDateTime(date);
        LocalDateTime plusMinutes = localDateTime.plusMinutes(1);
        return plusMinutes.isAfter(LocalDateTime.now());
    }
}
