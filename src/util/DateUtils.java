package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {
	  
	  public static String yyyyMMdd = "yyyyMMdd";

	  public static String yyyyMMddHHmmss = "yyyyMMddHHmmss";

	  public static String yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";

	  public static String yyyyMMddHHmmssForLoseTime = "yyyy-MM-dd HH:mm:ss";

	  public static String yyyyMMddHHmmssSplit = "yyyy-MM-dd-HH-mm-ss";

	  public static String yyyyNMMYddHHHmm = "yyyy年MM月dd号 HH时mm分";// 格式2011年4月20号4时23分

	  public static String yyyyMMddSplit = "yyyy-MM-dd";

	  public static String HHmm = "HHmm";

	  public static String kkmm = "kkmm";

	  public static String HHmmSplit = "HH:mm";

	  public static String HHmmss = "HHmmss";

	  public static String HHmmssSplit = "HH:mm:ss";

	  public static String MMYddR = "MM月dd日";
	  
	  public static String yyyyMMYddR = "yyyy年MM月dd日";

	  public static final String PHONE_TRANS_FORMAT = "MMM dd yyyy h:mma";
	  
	  	/**
		 * 获取当前时间
		 * 
		 * @param date
		 * @return
		 */
	  public static Date getCurrentDate() {
	    return new Date(System.currentTimeMillis());
	  }

	  /**
	   * 根据给定的格式把日期格式化为字符串
	   * 
	   * @author llf
	   * @param date
	   * @param format
	   * @return
	   */
	  public static String dateToString(Date date, String format) {
	      SimpleDateFormat formatter = new SimpleDateFormat(format);
	      return formatter.format(date);
	  }
	  
	  public static String getCurrentDateyyyMMdd() {
		  
		  
	      SimpleDateFormat formatter = new SimpleDateFormat(yyyyMMddSplit);
	      
	      Calendar c=Calendar.getInstance();
	      
	      return formatter.format(c.getTime());
	  }
	  	/**
		 * 将时间置为23时59分钟59秒
		 * 
		 * @param date
		 * @return
		 */
	  public static Date setFullPassDay(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 23);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.SECOND, 59);
	    return calendar.getTime();
	  }

	  	/**
		 * 将时间后退2小时
		 * 
		 * @param date
		 * @return
		 */
	  public static Date getFallBack2Hour(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 2);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	  }

	  	/**
		 * 
		 * 
		 * 获取某时间往后推N小时的时间
		 * 
		 * @author Scofield
		 * @param date
		 * @param hour
		 * @return
		 */
	  public static Date getFallAfterSomeHour(Date date, int hour) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY)
	        + hour);
	    return calendar.getTime();
	  }

	  	/**
		 * 将时间精确到小时
		 * 
		 * @param date
		 * @return
		 */
	  public static Date getTimeHour(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	  }

	  	/**
		 * 获取两个时间间隔的天数
		 * 
		 * @param date
		 * @return
		 */
	  public static long getDiffDays(Date startDate, Date endDate) {
	    long difftime = endDate.getTime() - startDate.getTime();
	    return difftime / (24L * 60L * 60L * 1000L);
	  }

	  	/**
		 * 根据日期获取当天起始时间
		 * 
		 * @author jombowang
		 * @param date
		 * @return
		 */
	  public static Date getStartDateOfCurrentDay(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	  }

	  public static Date getStartYesterday(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DAY_OF_MONTH, -1);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	  }

	  	/**
		 * 根据日期获取下一天起始时间
		 * 
		 * @author jombowang
		 * @param date
		 * @return
		 */
	  public static Date getStartDateOfNextDay(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DAY_OF_MONTH, 1);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	  }
	  
	  public static String getStartDateOfDay(Date date,int n) {
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    calendar.add(Calendar.DAY_OF_MONTH, n);
		    calendar.set(Calendar.HOUR_OF_DAY, 0);
		    calendar.set(Calendar.MINUTE, 0);
		    calendar.set(Calendar.SECOND, 0);
		    calendar.set(Calendar.MILLISECOND, 0);
		    
		    return dateToString(calendar.getTime(),"yyyy-MM-dd");	 
		  }
	  public static Date getStartDateOfDays(Date date,int n) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DAY_OF_MONTH, n);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    
	    return calendar.getTime();    
	  }
	  	/**
		 * 根据日期当前日期顺延一周后的起始时间
		 * 
		 * @author jombowang
		 * @param date
		 * @return
		 */
	  public static Date getStartDateOfNextSevenDay(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DAY_OF_MONTH, 7);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	  }

	  	/**
		 * 根据日期当前日期获取当月开始时间
		 * 
		 * @author jombowang
		 * @param date
		 * @return
		 */
	  public static Date getStartDateOfMonth(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.DAY_OF_MONTH, 1);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	  }

	  	/**
		 * 根据日期当前日期顺延一月后的起始时间
		 * 
		 * @author jombowang
		 * @param date
		 * @return
		 */
	  public static Date getStartDateOfNextMonth(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.MONTH, 1);
	    calendar.set(Calendar.DAY_OF_MONTH, 1);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	  }

	  	/**
		 * 
		 * 
		 * 获取当前月份最后一天
		 * 
		 * @author Scofield
		 * @param date
		 * @return
		 */
	  public static Date getEndDateOfMonth(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.MONTH, 1);
	    calendar.set(Calendar.DAY_OF_MONTH, 0);
	    calendar.set(Calendar.HOUR_OF_DAY, 23);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.SECOND, 59);
	    calendar.set(Calendar.MILLISECOND, 999);
	    return calendar.getTime();
	  }

	  	/*
		 * 封装一天只能的时间区域
		 */

	  public static List<Date> getStaticByDateDateArea(Date date) {
	    List<Date> dates = new ArrayList<Date>();
	    Date startdate = getStartDateOfCurrentDay(date);
	    Date nextday = getStartDateOfNextDay(date);
	    int step = 2;
	    dates.add(startdate);
	    for (int i = 1; i < 12; i++) {
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(startdate);
	      calendar.add(Calendar.HOUR_OF_DAY, i * step);
	      dates.add(calendar.getTime());
	    }
	    dates.add(nextday);
	    return dates;
	  }

	  	/*
		 * 封装一周7天之内时间区域当前时间顺延6天
		 */
	  public static List<Date> getStaticByWeekDateArea(Date date) {
	    List<Date> dates = new ArrayList<Date>();
	    Date startdate = getStartDateOfCurrentDay(date);
	    Date nextday = getStartDateOfNextSevenDay(date);
	    dates.add(startdate);
	    for (int i = 1; i < 7; i++) {
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(startdate);
	      calendar.add(Calendar.DAY_OF_MONTH, i);
	      dates.add(calendar.getTime());
	    }
	    dates.add(nextday);
	    return dates;
	  }

	  	/*
		 * 封装一周之内时间区域List<String>
		 */
	  public static List<String> getStaticByWeekLabel(Date date) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
	    List<String> dates = new ArrayList<String>();
	    Date startdate = getStartDateOfCurrentDay(date);
	    Date nextday = getStartDateOfNextSevenDay(date);
	    dates.add(dateFormat.format(startdate));
	    for (int i = 1; i < 7; i++) {
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(startdate);
	      calendar.add(Calendar.DAY_OF_MONTH, i);
	      dates.add(dateFormat.format(calendar.getTime()));
	    }
	    return dates;
	  }

	  	/*
		 * 封装一周之内时间区域从周日开始到周日
		 */
	  public static List<Date> getStaticByWeekDateArea76(Date date) {
	    List<Date> dates = new ArrayList<Date>();
	    int weeknum = 0;
	    for (int i = 0; i <= 7; i++) {
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(date);
	      weeknum = calendar.get(Calendar.DAY_OF_WEEK) - 1;
	      calendar.add(Calendar.DAY_OF_WEEK, i - weeknum);
	      dates.add(calendar.getTime());
	    }
	    return dates;
	  }

	  	/*
		 * 封装一周之内时间区域从周日开始到周六
		 */
	  public static List<String> getStaticByWeekLable76(Date date) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd");
	    List<String> dates = new ArrayList<String>();
	    int weeknum = 0;
	    for (int i = 0; i < 7; i++) {
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(date);
	      weeknum = calendar.get(Calendar.DAY_OF_WEEK) - 1;
	      calendar.add(Calendar.DAY_OF_WEEK, i - weeknum);
	      dates.add(dateFormat.format(calendar.getTime()));
	    }
	    return dates;
	  }

	  	/*
		 * 封装一月之内时间区域
		 */
	  public static List<Date> getStaticByMonthDateArea(Date date) {
	    List<Date> dates = new ArrayList<Date>();
	    Date startdate = getStartDateOfMonth(date);
	    Date nextday = getStartDateOfNextMonth(date);
	    long daydiff = getDiffDays(startdate, nextday);
	    dates.add(startdate);
	    for (int i = 1; i < daydiff; i++) {
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(startdate);
	      calendar.add(Calendar.DAY_OF_MONTH, i);
	      dates.add(calendar.getTime());
	    }
	    dates.add(nextday);
	    return dates;
	  }

	  	/*
		 * 封装一点时间之内的时间区域（天）
		 */
	  public static List<Date> getStaticBySE(Date startDate, Date endDate) {
	    List<Date> dates = new ArrayList<Date>();

	    long daydiff = getDiffDays(startDate, endDate);
	    dates.add(startDate);
	    for (int i = 1; i < daydiff; i++) {
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(startDate);
	      calendar.add(Calendar.DAY_OF_MONTH, i);
	      dates.add(calendar.getTime());
	    }
	    dates.add(endDate);
	    return dates;
	  }

	  	/*
		 * 封装一月之内时间区域
		 */
	  public static List<String> getStaticByMonthLabel(Date date) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
	    List<String> dates = new ArrayList<String>();
	    Date startdate = getStartDateOfMonth(date);
	    Date nextday = getStartDateOfNextMonth(date);
	    long daydiff = getDiffDays(startdate, nextday);
	    dates.add(dateFormat.format(startdate));
	    for (int i = 1; i < daydiff; i++) {
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(startdate);
	      calendar.add(Calendar.DAY_OF_MONTH, i);
	      dates.add(dateFormat.format(calendar.getTime()));
	    }
	    return dates;
	  }

	  public static List<String> getStaticByMonthLabel(Date date, String format) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat(format);
	    List<String> dates = new ArrayList<String>();
	    Date startdate = getStartDateOfMonth(date);
	    Date nextday = getStartDateOfNextMonth(date);
	    long daydiff = getDiffDays(startdate, nextday);
	    dates.add(dateFormat.format(startdate));
	    for (int i = 1; i < daydiff; i++) {
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTime(startdate);
	      calendar.add(Calendar.DAY_OF_MONTH, i);
	      dates.add(dateFormat.format(calendar.getTime()));
	    }
	    return dates;
	  }

	  public static String formatDate(String format, Date date) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat(format);
	    return dateFormat.format(date);
	  }
	  
	  public static Date formString(String format, String date)
	      throws ParseException {
	    SimpleDateFormat dateFormat = new SimpleDateFormat(format);
	    return dateFormat.parse(date);
	  }

	  	/**
		 * 获取给定时间的2号凌晨2时零分零秒零毫秒
		 * 
		 * @param date
		 * @return
		 */
	  public static Date getDate0022(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.DAY_OF_MONTH, 2);
	    calendar.set(Calendar.HOUR_OF_DAY, 2);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();

	  }

	  	/**
		 * 获取给定时间的23时59分零秒零毫秒
		 * 
		 * @param date
		 * @return
		 */
	  public static Date getDate05923(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 23);
	    calendar.set(Calendar.MINUTE, 59);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();

	  }

	  	/**
		 * 获取给定时间的3时0分零秒零毫秒
		 * 
		 * @param date
		 * @return
		 */
	  public static Date getDate003(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 3);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();

	  }

	  	/**
		 * 获取给定时间的凌晨2时零分零秒零毫秒
		 * 
		 * @param date
		 * @return
		 */
	  public static Date getDate002(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 2);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();

	  }

	  	/**
		 * 获取给定时间的凌晨0时15分零秒零毫秒
		 * 
		 * @param date
		 * @return
		 */
	  public static Date getDate0150(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 15);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();

	  }

	  	/**
		 * 获取给定时间的0分零秒零毫秒
		 * 
		 * @param date
		 * @return
		 */
	  public static Date getDate00(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();

	  }

	  	/**
		 * 获取给定时间的0时0分零秒零毫秒
		 * 
		 * @param date
		 * @return
		 */
	  public static Date getDate000(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	  }

	  	/**
		 * 获取给定时间的50分零秒零毫秒
		 * 
		 * @param date
		 * @return
		 */
	  public static Date getDate050(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.MINUTE, 50);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();

	  }

	  public static Date getDateWhere(int y, int MM, int d, int h, int m, int s) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(new Date());
	    calendar.set(Calendar.YEAR, y);
	    calendar.set(Calendar.MONTH, MM);
	    calendar.set(Calendar.DAY_OF_MONTH, d);
	    calendar.set(Calendar.HOUR_OF_DAY, h);
	    calendar.set(Calendar.MINUTE, m);
	    calendar.set(Calendar.SECOND, s);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	  }

	  public static Date getMidday12(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.set(Calendar.HOUR_OF_DAY, 12);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	  }

	  public static Date getNextMonth15(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.MONTH, -1);
	    calendar.set(Calendar.DAY_OF_MONTH, 15);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	  }

	  public static Date getDateBefore14(Date date, int befroeDay) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DAY_OF_MONTH, befroeDay);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	  }

	  public static Date getDateAfter30(Date date, int afterDay) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DAY_OF_MONTH, afterDay);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	  }

	  	/**
		 * 往前退30分钟
		 * 
		 * @param date
		 * @return
		 */
	  public static Date getDateBefore30m(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.MINUTE, -30);
	    return calendar.getTime();

	  }

	  	/**
		 * 往前退12小时
		 * 
		 * @param date
		 * @return
		 */
	  public static Date getDateBefore12h(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.HOUR_OF_DAY, -12);
	    return calendar.getTime();

	  }

	  	/**
		 * 往前退10天
		 * 
		 * @param date
		 * @return
		 */
	  public static Date getDateBefore10d(Date date) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DAY_OF_MONTH, -10);
	    return calendar.getTime();

	  }
	  
	  /**
	   * 往前退1天
	   * 
	   * @param date
	   * @return
	   */
	public static Date getDateBefore1d(Date date) {
	  Calendar calendar = Calendar.getInstance();
	  calendar.setTime(date);
	  calendar.add(Calendar.DAY_OF_MONTH, -1);
	  return calendar.getTime();

	}


	  	/**
		 * 获取两个日期间所有日期
		 * 
		 * 
		 * @author Administrator
		 * @param beginDate
		 * @param endDate
		 * @return
		 */
	  public static List<Date> getDatesOf2Date(Date beginDate, Date endDate) {
	   int i = 0;
	   Calendar begin = Calendar.getInstance();
	   begin.setTime(beginDate);
	   Calendar end = Calendar.getInstance();
	   end.setTime(endDate);
	    List<Date> result = new ArrayList<Date>();
	    while(true){
	      Calendar c=  Calendar.getInstance();
	      c.setTime(beginDate);
	      c.set(Calendar.DATE,c.get(Calendar.DATE) + i++);
	      c.set(Calendar.HOUR_OF_DAY,0);
	      c.set(Calendar.MINUTE,0);
	      c.set(Calendar.SECOND, 0);
	      c.set(Calendar.MILLISECOND, 0);
	      
	      if(c.after(end)){
	        break;
	      }
	      
	      if(!c.before(begin)) {
	        result.add(c.getTime());
	      }
	      
	      
	      
	    }
	    return result;
	  }

	  	/**
		 * 获取两个日期之间的 指定星期几
		 * 
		 * 
		 * @param beginDate
		 * @param endDate
		 * @param dateOfWeek
		 * @return
		 */
	  public static List<Date> getInDateOfEveryDateOfWeek(Date beginDate,
	      Date endDate, int[] dateOfWeek) {
	    List<Date> result = new ArrayList<Date>();
	    while (true) {
	      Date d = beginDate;
	      int day = d.getDay();
	      for (int i = 0; i < dateOfWeek.length; i++) {
	        if (day == dateOfWeek[i]) {
	          result.add(new Date(d.getTime()));
	          continue;
	        }
	      }
	      d.setDate(d.getDate() + 1);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String startDate = sdf.format(d);
				String finshDate = sdf.format(endDate);
				d = DateUtils.convert(startDate);
				endDate = DateUtils.convert(finshDate);
				if (d.after(endDate)) {
	        break;
	      }
	    }
	    return result;
	  }

	  public static Date getDateAfteDays(Date date, int days) {
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DAY_OF_MONTH, days);
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    calendar.set(Calendar.MILLISECOND, 0);
	    return calendar.getTime();
	  }

	  public static void main(String[] args) throws ParseException {
//	    System.out.println(DateUtils.formatDate("yyyy-MM-dd HH:mm:ss",
//	        getFallAfterSomeHour(new Date(), 3)));
	    Date d = new Date();
	    d.setHours(0);
	    d.setMinutes(0);
	    d.setSeconds(0);
	    Date d2 = new Date();
	   d2. setDate(new Date().getDate() + 5);
	   List l =  getDatesOf2Date(d,d2);
	   System.out.println(l);
	   
	  }

	  	/**
		 * 判断时间是否在两个时间之内
		 * 
		 * 
		 * @author scofiled
		 * @param checkDate
		 * @param start
		 * @param end
		 * @return
		 */
	  public static boolean checkIsBetween(Date checkDate, Date start, Date end) {
//	    return checkDate.after(start) && checkDate.before(end);
	    if(checkDate.compareTo(start)>=0 && end.compareTo(checkDate)>=0)
	    	return true;
	    return false;
	  }

		public static Date convert(String source) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date result = null;
			if (source.length() == 0) {
				return result;
			}
			try {
				result = sdf.parse(source);
			} catch (Exception e) {
				result = new Date(0);
			}
			return result;
		}
		
		/**
	     * 根据给定的格式把字符串格式化为日期
	     * 
	     * @param dateStr
	     * @param format
	     * @return
	     */
	    public static Date stringToDate(String dateStr, String format) {
	        SimpleDateFormat formater = new SimpleDateFormat(format);
	        Date date = null;
	        try {
	            date = formater.parse(dateStr);
	        } catch (Exception e) {
	          date = new Date(0);
	        }
	        return date;
	    }
//	    public static Long comareStrDate(String strDate1,String strDate2){
//	    	DateTime dt1 = Date.parse(strDate1);
//	   	 	DateTime dt2 = DateTime.parse(strDate2);
//	   	 	//开始小于结束 return 1
//	   	 	return dt1.getMillis()-dt2.getMillis();
//	    }
	    /**
	     * 获取系统当前日期时间（毫秒,字符串类型）：格式yyyyMMddHHmmssSSS
	     * @return
	     */
	    public static String getSysTimeStr_yyyyMMddHHmmssSSS() {
	        // 按指定格式格式化日期
	        SimpleDateFormat formater = new SimpleDateFormat(yyyyMMddHHmmssSSS);
	        // 返回格式化后的结果
	        return formater.format(getSysTime());
	    }
	    
	    /**
	     * 获取系统当前日期时间（Date类型）：格式yyyyMMddHHmmss
	     * @return
	     */
	    public static Date getSysTime() {
	        // 获得日历类实例
	        Calendar c = Calendar.getInstance();
	        // 返回格式化后的结果
	        return c.getTime();
	    }

	  /***
	   * 
	   * 订单失效时间48小时
	   * 
	   * @author cora.guo
	   * @return
	   */
	  public static String getStartDate(Date date,Integer hour) {
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    c.add(Calendar.HOUR, +hour);
	    return dateToString(c.getTime(), yyyyMMddHHmmssForLoseTime);
	  }


	}
