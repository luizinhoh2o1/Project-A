package com.alone.projecta.services.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateFormat {
	
	public static Date getDateNow() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		Date newDate =  new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(newDate);
		cal.add(Calendar.MONTH, 3);
		newDate = cal.getTime();
		
		return newDate;
	}
}