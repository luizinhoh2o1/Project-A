package com.alone.projecta.services.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class GenerateCurrentDate {

	public static Date getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		Date newDate = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(newDate);
		newDate = cal.getTime();
		return newDate;
	}

	public static Date extendMonthsDate(Date date, Integer months) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, months);
		date = cal.getTime();
		return date;
	}
	
	public static Date getCurrentDateAndExtendMonths(Integer months) {
		return extendMonthsDate(getCurrentDate(), months);
	}
}