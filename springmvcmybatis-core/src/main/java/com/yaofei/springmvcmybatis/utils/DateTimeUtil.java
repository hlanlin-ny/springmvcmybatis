package com.yaofei.springmvcmybatis.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 */
public class DateTimeUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);
	
	public static long currentTimeMillisUTC(){
		return System.currentTimeMillis();
    	//return calendarUTC().getTimeInMillis();
	}
	
	public static Date currentDateTimeUTC(){
		return new Date();		
		//return calendarUTC().getTime();
	}
	
	
//	public static Calendar calendarUTC(){
//		//java.util.Calendar cal=java.util.Calendar.getInstance(TimeZone.getTimeZone("MST"));
//		TimeZone tz=TimeZone.getTimeZone("UTC");
//		java.util.Calendar cal = java.util.Calendar.getInstance();  
//		cal.setTimeZone(TimeZone.getTimeZone("UTC"));
//
//    	cal.setTimeZone(TimeZone.getTimeZone("Etc/GMT+7"));
//    	System.out.println("DB:"+cal.getTimeInMillis());
//    	System.out.println("DB:"+cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DAY_OF_MONTH)
//    			+" "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));
//    	cal = new GregorianCalendar();
//    	cal.setTimeZone(TimeZone.getTimeZone("Etc/GMT+7"));
//    	System.out.println("GMT+7:"+cal.getTimeInMillis());
//    	System.out.println("GMT+7:"+cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DAY_OF_MONTH)
//    			+" "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));
//    	
//    	cal.setTimeZone(TimeZone.getTimeZone("MST"));
//    	System.out.println("MST"+cal.getTimeInMillis());
//    	System.out.println("MST"+cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DAY_OF_MONTH)
//    			+" "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));
//    	
//    	cal.setTimeZone(TimeZone.getTimeZone("UTC"));
//    	System.out.println("UTC"+cal.getTimeInMillis());
//    	System.out.println("UTC"+cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DAY_OF_MONTH)
//    			+" "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND));
//
//    	return cal;
//	}
	
	public static String format(Date date, String format,String timezoneid){
		return null;
	}
	
    public static String format(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }

    public static String formatDateTime(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    /**
     * 格式化日期
     *
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static Date parse(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(date);
        } catch (Exception ex) {
            return null;
        }
    }

    public static Date parse(String date, String arg0) {
        SimpleDateFormat sdf = new SimpleDateFormat(arg0);
        try {
            return sdf.parse(date);
        } catch (Exception ex) {
            return null;
        }
    }

    public static String key_Month() {
        String month = "";
        Calendar c = Calendar.getInstance();
        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH) + 1;
        if (m < 10) {
            month = y + "-0" + m;
        } else {
            month = y + "-" + m;
        }
        return month;
    }

    public static String key_Day() {
        String day = "";
        Calendar c = Calendar.getInstance();
        int y = c.get(Calendar.YEAR);
        int m = c.get(Calendar.MONTH) + 1;
        int d = c.get(Calendar.DAY_OF_MONTH);
        if (m < 10) {
            day = y + "-0" + m;
        } else {
            day = y + "-" + m;
        }
        if (d < 10) {
            day = day + "-0" + d;
        } else {
            day = day + "-" + d;
        }
        return day;
    }

    public static String key_Hour() {
        String hour = key_Day();
        Calendar c = Calendar.getInstance();
        int h = c.get(Calendar.HOUR_OF_DAY);
        if (h < 10) {
            hour = hour + " 0" + h;
        } else {
            hour = hour + " " + h;
        }
        hour = hour + ":00:00";
        return hour;
    }

    public static String key_HalfHour() {
        String halfHour = key_Day();
        Calendar c = Calendar.getInstance();
        int h = c.get(Calendar.HOUR_OF_DAY);
        int m = c.get(Calendar.MINUTE);
        if (h < 10) {
            halfHour = halfHour + " 0" + h;
        } else {
            halfHour = halfHour + " " + h;
        }
        if (m < 30) {
            halfHour = halfHour + ":00:00";
        } else {
            halfHour = halfHour + ":30:00";
        }
        return halfHour;
    }

    public static Date getBeginTimeOfDay(Date date) {
        date = parse(DateTimeUtil.format(date) + " 00:00:00:000", "yyyy-MM-dd HH:mm:ss:SSS");
        return date;
    }

    public static Date getEndTimeOfDay(Date date) {
        date = parse(DateTimeUtil.format(date) + " 23:59:59:999", "yyyy-MM-dd HH:mm:ss:SSS");
        return date;
    }

    public static void main(String[] args) {
        System.out.println(DateTimeUtil.key_Month());
        System.out.println(DateTimeUtil.key_Day());
        System.out.println(DateTimeUtil.key_Hour());
        System.out.println(DateTimeUtil.key_HalfHour());

//        Calendar c = Calendar.getInstance();
//        c.add(Calendar.DAY_OF_MONTH, -1);
//        int y = c.get(Calendar.YEAR);
//        int m = c.get(Calendar.MONTH) + 1;
//        int d = c.get(Calendar.DAY_OF_MONTH);
//        String day = y + "-" + m + "-" + d;
//        System.out.println(day);

        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR_OF_DAY, 8);
        System.out.println(c.getTime());

    }


    /**
     * 一天有多少毫秒
     */
    public static final long MILLI_SECONDS_PER_DAY = 3600 * 24 * 1000;

    /**
     * 把日期格式化为yyyy-MM-dd格式的字符串
     *
     * @param date
     *            日期对象
     * @return yyyy-MM-dd
     */
    public static String getFormatDate(Date date) {
        try {
            SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
            String result = formater.format(date);
            return result;
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 把yyyy-MM-dd格式的字符串转换为另一种格式
     *
     * @param source
     *            yyyy-MM-dd格式的字符串
     * @param pattern
     *            另外一种格式
     * @return 日期字符串
     */
    public static String getFormatDate(String source, String pattern) {
        SimpleDateFormat formator = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formator.parse(source);
            SimpleDateFormat targetformator = new SimpleDateFormat(pattern);
            return targetformator.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 把日期转换成对应格式的字符串
     *
     * @param source
     *            日期对象
     * @param pattern
     *            日期格式
     * @return 日期字符串
     */
    public static String getFormatDate(Date source, String pattern) {
        try {
            SimpleDateFormat targetformator = new SimpleDateFormat(pattern);
            return targetformator.format(source);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 把日期转换成对应格式的字符串
     *
     * @param source
     *            日期对象
     * @return 日期字符串
     */
    public static String getFormatTime(Date source) {
        try {
            SimpleDateFormat targetformator = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return targetformator.format(source);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 把日期字符串转换成另外一种格式
     *
     * @param source
     *            日期字符串
     * @param sourcePatton
     *            日期格式
     * @param pattern
     *            要转换成的日期格式
     * @return 日期字符串
     */
    public static String getFormatDate(String source, String sourcePatton, String pattern) {
        SimpleDateFormat formator = new SimpleDateFormat(sourcePatton);
        try {
            Date date = formator.parse(source);
            SimpleDateFormat targetformator = new SimpleDateFormat(pattern);
            return targetformator.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 把字符串转换成日期对象
     *
     * @param source
     *            字符串
     * @param sourcePattern
     *            字符串格式
     * @return 日期对象
     */
    public static Date getDateFromStr(String source, String sourcePattern) {
        SimpleDateFormat formator = new SimpleDateFormat(sourcePattern);
        try {
            Date date = formator.parse(source);
            return date;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 把yyyy-MM-dd格式的字符串转换成日期
     *
     * @param source
     *            yyyy-MM-dd格式的字符串
     * @return Date
     */
    public static Date getDateFromStr(String source) {
        SimpleDateFormat formator = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = formator.parse(source);
            return date;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取本地长格式时间（14位）
     *
     * @return 本地长格式时间
     */
    public static String getLocalLongDate14() {
        String dateString = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss", Locale.US);
        dateString = formatter.format(new Date());
        return dateString;
    }

    /**
     * 获取本地长格式时间（6位）时分秒
     *
     * @return 本地长格式时间
     */
    public static String getLocalLongSecond6() {
        String secondString = "";
        SimpleDateFormat formatter = new SimpleDateFormat("HHmmss", Locale.US);
        secondString = formatter.format(new Date());
        return secondString;
    }

    /**
     * 获取本地长格式时间（9位）时分秒毫秒
     *
     * @return 本地长格式时间
     */
    public static String getLocalLongMisSecond9() {
        String secondString = "";
        SimpleDateFormat formatter = new SimpleDateFormat("HHmmssSSS", Locale.US);
        secondString = formatter.format(new Date());
        return secondString;
    }

    /**
     * 取得当前时间的字符串
     *
     * @return yyyy-MM-dd HH:mm:ss格式的字符串
     */
    public static String getNowDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curTime = sdf.format(new Date());
        return curTime;
    }

    /**
     * 得到两个日期的间隔天数
     *
     * @param begin
     *            起始日期
     * @param end
     *            结束日期
     *            <p/>
     *            日期格式
     * @return 天数
     */
    public static int getDayInterval(Date begin, Date end) {
        return (int) ((end.getTime() - begin.getTime()) / 1000 / 60 / 60 / 24 );
    }

    /**
     * 取得月份间隔，忽略天数
     *
     * @param begin
     *            开始日期
     * @param end
     *            结束日期
     * @return 月份数
     */
    public static int getMonthInterval(Date begin, Date end) {
        // 1、取得两个日期的月份，计算差值d
        // 2、取得两个日期的年份，计算差值m
        // 3、如果d<0,那么m*12+d就是间隔；如果d>0，那么m*12+d就是间隔
        int result = 0;
        Calendar cBegin = Calendar.getInstance();
        cBegin.setTime(begin);
        int bm = cBegin.get(Calendar.MONTH);
        int by = cBegin.get(Calendar.YEAR);

        Calendar cEnd = Calendar.getInstance();
        cEnd.setTime(end);
        int em = cEnd.get(Calendar.MONTH);
        int ey = cEnd.get(Calendar.YEAR);

        result = (ey - by) * 12 + (em - bm);

        return result;
    }

    /**
     * 取得系统当前的时间，以Timestamp 表示
     *
     * @return 返回Timestamp对象
     */
    public static Timestamp getDateTime() {
        Date date = new Date();
        return (new Timestamp(date.getTime()));
    }

    /**
     * 将指定日期转换为指定格式的字符串
     *
     * @param ts
     *            ( java.util.Timestamp )
     * @param pattern
     *            日期格式，如："yyyy-MM-dd" ，"yyyy-MM-dd HH:mm:ss"，"HH:mm:ss"
     * @return String
     */
    public static String getDateStringByPattern(Timestamp ts, String pattern) {
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        String str = sf.format(ts);
        return str;
    }

    /**
     * 取得当前日期
     *
     * @return Date
     */
    public static Date getCurrentDate() {
        Date date = new Date();
        return date;
    }


    /**
     * 获取当前时间的整小时时间
     * @return
     */
    public static Date getCurrentDateJustHour() {
        Date date = new Date();

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * 得到本月的第一天
     *
     * @return
     */
    public static Timestamp getMonthFirstDay(Integer monthoffset) {
        return getMonthFirstDay(monthoffset, null);
    }

    /**
     * 得到某月的第一天
     *
     * @return
     */
    public static Timestamp getMonthFirstDay(Integer monthoffset, Timestamp time) {
        Calendar calendar = Calendar.getInstance();
        if (time != null) {
            calendar.setTime(time);
        }
        if (monthoffset != null) {
            calendar.add(Calendar.MONTH, monthoffset);
        }
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));

        Date date = getDateFromStr(getFormatDate(calendar.getTime()));
        return new Timestamp(date.getTime());
    }

    /**
     * 得到本月的最后一天
     *
     * @return
     */
    public static Timestamp getMonthLastDay(Integer monthoffset) {
        return getMonthLastDay(monthoffset, null);
    }

    /**
     * 得到本月的最后一天
     *
     * @return
     */
    public static Timestamp getMonthLastDay(Integer monthoffset, Timestamp time) {
        Calendar calendar = Calendar.getInstance();
        if (time != null) {
            calendar.setTime(time);
        }
        if (monthoffset != null) {
            calendar.add(Calendar.MONTH, monthoffset);
        }
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        Date date = getDateFromStr(getFormatDate(calendar.getTime()));
        return new Timestamp(date.getTime());
    }

    /**
     * 得到理论上不可到达时间 暂定为3000-01-01
     *
     * @return
     */
    public static Timestamp getMaxTime() {
        String maxtime = "3000-01-01";
        Date date = getDateFromStr(maxtime);
        return new Timestamp(date.getTime());
    }

    /**
     * 得到两个日期的间隔毫秒数
     *
     * @param begin
     *            起始日期
     * @param end
     *            结束日期
     *            <p/>
     *            日期格式
     * @return 天数
     */
    public static long getTimeInterval(Date begin, Date end) {
        return (end.getTime() - begin.getTime());
    }

    /**
     * 增减时间
     *
     * @param begin
     *            开始时间
     * @param offset
     *            毫秒数
     * @return
     */
    public static Timestamp caculateTime(Timestamp begin, Long offset) {
        long result = begin.getTime() + offset;
        return new Timestamp(result);
    }

    /**
     * dateString must be yyyy-mm-dd hh:mi:ss
     *
     * @param dateString
     *            日期字符串
     * @return Timestamp
     */
    public static Timestamp getTimestamp(String dateString) {
        try {
            return Timestamp.valueOf(dateString);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * 获取随机日期
     *
     * @param beginTime
     * @param endTime
     * @return
     */
    public static Timestamp randomDate(Timestamp beginTime, Timestamp endTime) {
        try {
            if (beginTime.after(endTime)) {
                return null;
            }
            long time = random(beginTime.getTime(), endTime.getTime());
            return new Timestamp(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static long random(long begin, long end) {
        long rtn = begin + (long) (Math.random() * (end - begin));
        if (rtn == begin || rtn == end) {
            return random(begin, end);
        }
        return rtn;
    }

    /**
     * 随机获取某时间段之间的日期
     *
     * @param beginTime
     * @param endTime
     * @return
     */
    public static Timestamp randomTime(Timestamp beginTime, Timestamp endTime) {
        try {
            if (beginTime.after(endTime)) {
                return null;
            }
            long time = random(beginTime.getTime(), endTime.getTime());
            Calendar c = Calendar.getInstance();
            c.setTime(new Date(time));
            return new Timestamp(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getYesterday() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    /**
     * @param currentDate
     *            指定日期
     * @return 指定日期的前一天
     */
    public static Date getPrevDate(Date currentDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);

        int date = cal.get(Calendar.DATE);
        cal.set(Calendar.DATE, date - 1);

        return cal.getTime();

    }

    /**
     * @return 当前日期的前一天
     */
    public static Date getPrevDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateTimeUtil.getCurrentDate());

        int date = cal.get(Calendar.DATE);
        cal.set(Calendar.DATE, date - 1);

        return cal.getTime();

    }

    /**
     * @param currentDate
     *            指定日期
     * @return 指定日期的后一天
     */
    public static Date getNextDate(Date currentDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);

        int date = cal.get(Calendar.DATE);
        cal.set(Calendar.DATE, date + 1);

        return cal.getTime();

    }

    /**
     * @param date
     * @return 该天的第一秒时间
     */
    public static Date getBeginOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);

        return cal.getTime();
    }

    /**
     * @param date
     * @return 该天的最后一秒时间
     */
    public static Date getEndOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);

        return cal.getTime();
    }

    /**
     * @param dateStr 日期字符串 yyyy-mm-dd
     * @return 该天的最后一秒时间
     */
    public static Date getEndOfDayFromStr(String dateStr) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(DateTimeUtil.getDateFromStr(dateStr));

        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);

        return cal.getTime();
    }

    /**
     * @param date1
     * @param date2
     * @return date1和date2是否是在同一天
     */
    public static boolean isInSameDay(Date date1, Date date2) {
        String dateStr1 = DateTimeUtil.getFormatDate(date1);
        String dateStr2 = DateTimeUtil.getFormatDate(date2);

        return dateStr1.equals(dateStr2);
    }

    /**
     * @param startDate
     *            开始日期
     * @param endDate
     *            结束日期
     * @return 计算两个日期之间相差的星期数， 如果开始日期在结束日期之后，则返回-1
     */
    public static int getWeekInterval(Date startDate, Date endDate) {

        if (startDate.after(endDate)) {
            return -1;
        }

        long days = (endDate.getTime() - startDate.getTime()) / MILLI_SECONDS_PER_DAY;
        int weeks = (int) (days / 7);
        return weeks;
    }

    /**
     * @param date1
     *            前面的日期
     * @param date2
     *            后面的日期
     * @return 后面的日期是否是前面日期的后一天，精确到秒
     */
    public static boolean isContinousDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        cal2.add(Calendar.DATE, -1);

        return (cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));

    }

    /**
     * 判断是否为同一天，不同年
     *
     * @param date1
     * @return
     */
    public static boolean isSameDayWithoutYear(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        String yearFormat = "yyyy";
        String dayFormat = "MMdd";
        return !StringUtils.equals(getFormatDate(date1, yearFormat), getFormatDate(date2, yearFormat)) && StringUtils.equals(getFormatDate(date1, dayFormat), getFormatDate(date2, dayFormat));
    }

    /**
     * @param dateStr
     *            yyyy-mm-dd
     * @return 数字yyyymmmmdd
     */
    public static int getIntDate(String dateStr) {
        String[] strArray = StringUtils.split(dateStr, "-");
        return Integer.parseInt(StringUtils.join(strArray));
    }

    /**
     * 返回如20121026表示日期的数字
     *
     * @return
     */
    public static int getIntDate(Date date) {
        return NumberUtils.toInt(DateTimeUtil.getFormatDate(date, "yyyyMMdd"));
    }

    /**
     * 根据字符串返回date
     * @param dateStr
     * @return
     */
    public static Date datetimeFromStr(String dateStr){
        Date date = new Date();
        //注意format的格式要与日期String的格式相匹配
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
        return date;
    }

    /**
     * 根据字符串返回date
     * @param dateStr
     * @return
     */
    public static Date dateFromStr(String dateStr){
        Date date = new Date();
        //注意format的格式要与日期String的格式相匹配
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            logger.error(e.getMessage());
            return null;
        }
        return date;
    }


    /**
     * 得到日期的前或者后几天
     *
     * @param iDate
     *                如果要获得前几天日期，该参数为负数； 如果要获得后几天日期，该参数为正数
     * @see Calendar#add(int, int)
     * @return Date 返回参数<code>curDate</code>定义日期的前或者后几天
     */
    public static Date getDateBeforeOrAfter(Date curDate, int iDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.add(Calendar.DAY_OF_MONTH, iDate);
        return cal.getTime();
    }


    /**
     * 得到日期的前或者后几小时,小时整点
     *
     * @param curDate
     *                如果要获得前几天日期，该参数为负数； 如果要获得后几天日期，该参数为正数
     * @see Calendar#add(int, int)
     * @return Date 返回参数<code>curDate</code>定义日期的前或者后几天
     */
    public static Date getDateBeforeOrAfterHour(Date curDate, int iHour) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(curDate);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.HOUR_OF_DAY, iHour);
        return cal.getTime();
    }

    public static String getDateWithFormat(Date date,String format) {
        try {
            SimpleDateFormat formater = new SimpleDateFormat(format);
            String result = formater.format(date);
            return result;
        } catch (Exception e) {
            return "";
        }
    }

    public static String getTodayIndexPostfix() {
        return new SimpleDateFormat("YYYY-MM-dd").format(new Date());
    }

}