package net.ormlite.todo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String FORMAT_STR_DATE_yyyyMM = "yyyyMM";
    public static final String FORMAT_STR_DATE_yyyyMMdd = "yyyyMMdd";
    public static final String FORMAT_STR_DATE_HHmmss = "HH:mm:ss";
    public static final String FORMAT_STR_DATE_HHmm = "HH:mm";
    public static final String FORMAT_STR_DATE_yyyy_MM_dd = "yyyy-MM-dd";
    public static final String FORMAT_STR_DATE_yyyy_MM_dd_HHmmss = "yyyy-MM-dd HH:mm:ss";

    /**
     * 将long类型时间转为指定格式的文本字符串
     * @param time  long类型时间(ms)
     * @param format 如："yyyy-MM-dd"
     * @return
     */
    public static String formatDateStr(long time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.parseLong(String.valueOf(time))));
    }
}