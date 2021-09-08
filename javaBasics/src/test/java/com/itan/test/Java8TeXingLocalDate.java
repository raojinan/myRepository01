package com.itan.test;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @author raojinan
 * @version 1.0
 * @date 2021/8/8 17:21
 */
public class Java8TeXingLocalDate {
    /**
     * 日期时间 API,之前的date是线程不安全；
     * Java 8 在 java.time 包下提供了很多新的 API。以下为两个比较重要的 API：
     * 1.Local(本地) − 简化了日期时间的处理，没有时区的问题。
     * 2.Zoned(时区) − 通过制定的时区处理日期时间。
     * 新的java.time包涵盖了所有处理日期，时间，日期/时间，时区，时刻（instants），过程（during）与时钟（clock）的操作
     */
    public void test01() {
        //表示日期的LocalDate    2021-08-08
        LocalDate today = LocalDate.now();
        //表示时间的LocalTime  17:17:25.243(纳秒)
        LocalTime localTime = LocalTime.now();
        //表示日期时间的LocalDateTime  2021-08-08T17:17:25.243
        LocalDateTime now = LocalDateTime.now();
        System.out.println(today);
        System.out.println(localTime);
        System.out.println(now);


    }

    //LocalDate
    public void test02() {
        //2018-05-04
        LocalDate today = LocalDate.now();
        // 取本月第1天： 2018-05-01
        LocalDate firstDayOfThisMonth = today.with(TemporalAdjusters.firstDayOfMonth());
        // 取本月第2天：2018-05-02
        LocalDate secondDayOfThisMonth = today.withDayOfMonth(2);
        // 取本月最后一天，再也不用计算是28，29，30还是31： 2018-05-31
        LocalDate lastDayOfThisMonth = today.with(TemporalAdjusters.lastDayOfMonth());
        // 取下一天：2018-06-01
        LocalDate firstDayOf2015 = lastDayOfThisMonth.plusDays(1);
        // 取2018年10月第一个周三 so easy?：  2018-10-03
        LocalDate thirdMondayOf2018 = LocalDate.parse("2018-10-01").with(TemporalAdjusters.firstInMonth(DayOfWeek.WEDNESDAY));

    }

    @Test
    public void test03() {
        //16:25:46.448(纳秒值)
        LocalTime todayTimeWithMillisTime = LocalTime.now();
        //16:28:48 不带纳秒值
        LocalTime todayTimeWithNoMillisTime = LocalTime.now().withNano(0);
        //23:59:59
        LocalTime time1 = LocalTime.parse("23:59:59");
        System.out.println(time1);


    }

    /**
     * LocalDateTime日期时间
     */
    @Test
    public void test04() {
        //转化为时间戳  毫秒值
        long time1 = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        //System.currentTimeMillis()产生一个当前的毫秒，这个毫秒其实就是自1970年1月1日0时起的毫秒数
        long time2 = System.currentTimeMillis();
        System.out.println(time1);
        System.out.println(time2);
        //时间戳转化为localDatetime
        DateTimeFormatter df = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss.SSS");
        System.out.println(df.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time1), ZoneId.of("Asia/Shanghai"))));

    }

    /**
     * DateTimeFormatter格式转换
     */
    @Test
    public void test05(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        //DateTimeFormatter
        //注意格式写对：yyyy-MM-dd HH:mm:ss
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(now);
        System.out.println(format);


    }

}
