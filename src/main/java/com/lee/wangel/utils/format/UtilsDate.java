package com.lee.wangel.utils.format;

import com.lee.wangel.utils.format.enums.EnumDateFormat;
import com.sun.istack.internal.NotNull;

import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *  工具类：日期
 * 2017/12/21 17:37 lee.wangel
 */
public class UtilsDate {

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(EnumDateFormat.yyyy_MM_dd.getFormat());

    /**
     * 当前时间
     * @return
     */
    public static Date getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(14, 0);
        return cal.getTime();
    }

    /**
     * 昨天时间
     * @return
     */
    public static Date getYesterdayDate() {
        return new Date(getCurTimeMillis() - 86400000L);
    }

    /**
     * 当前时间 毫秒数
     * @return
     */
    public static long getCurTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 日期格式转换成字符串
     * @param dataFormat：日期格式
     * @param date
     * @return
     */
    public static String formatToStr(@NotNull EnumDateFormat dataFormat,Date date) {
        if (date == null) {
            return "";
        } else {
            simpleDateFormat.applyPattern(dataFormat.getFormat());
            return simpleDateFormat.format(date);
        }
    }

    /**
     * 字符串格式转换成日期
     * @param dataFormat：字符串的格式
     * @param dateStr
     * @return
     */
    public static Date formatToDate(@NotNull EnumDateFormat dataFormat,String dateStr) {
        simpleDateFormat.applyPattern(dataFormat.getFormat());
        ParsePosition parseposition = new ParsePosition(0);
        return simpleDateFormat.parse(dateStr, parseposition);
    }

    /**
     * 日期格式转换成字符串
     * 默认使用的yyyy-MM-dd 格式
     * @param date
     * @return
     */
    public static synchronized String formatToDate(Date date) {
        return dateFormat.format(date);
    }

    /**
     * 年，月，日，整数类型转换成日期格式的字符串
     * 默认格式 xxxx年xx月xx日
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static String formatStrDate(int year, int month, int day) {
        StringBuilder sb = new StringBuilder(year + "");
        sb.append("年");
        if (month < 10) {
            sb.append("0");
        }

        sb.append(month).append("月");
        if (day < 10) {
            sb.append("0");
        }

        sb.append(day).append("日");
        return sb.toString();
    }

    /**
     * 判断日期格式的大小，oDate-fDate
     * oDate>fDate : >1
     * oDate=fDate : =1
     * oDate<fDate : <1
     * @param fDate
     * @param oDate
     * @return
     */
    public static int hasComparator(Date fDate, Date oDate) {
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(fDate);
        int day1 = aCalendar.get(6);
        aCalendar.setTime(oDate);
        int day2 = aCalendar.get(6);

        return day2 - day1;

    }


    /**
     * 读取连个时间中所包含的月份
     * 含当月份
     * @param dateFormat:月份字符串的格式
     * @param minDate:开始时间
     * @param maxDate:结束时间
     * @return
     */
    public static List<String> getTowTimeBetweenMonth(@NotNull EnumDateFormat dateFormat,Date minDate, Date maxDate) {
        ArrayList<String> result = new ArrayList<String>();


        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(minDate);
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(maxDate);
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;

        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat.getFormat());//格式化为年月
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }


        return result;
    }

    public static void main(String[] args) {
        String minDateStr = "2017-07-02";
        String maxDateStr = "2017-12-01";
        Date minDate = formatToDate(EnumDateFormat.yyyy_MM_dd,minDateStr);
        Date maxDate = formatToDate(EnumDateFormat.yyyy_MM_dd,maxDateStr);

        List<String> list = getTowTimeBetweenMonth(EnumDateFormat.yyMM,minDate,maxDate);
        System.out.println(list);
    }
}
