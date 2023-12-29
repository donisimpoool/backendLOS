package com.ikkat.los.utils;

import java.io.File;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import com.ikkat.los.entity.RunningNumberEntity;
//import com.ikkat.los.entity.UserEntity;
import com.ikkat.los.enumeration.DateFormatEnum;
import com.ikkat.los.service.CompanyService;
import com.ikkat.los.service.RunningNumberService;
//import com.ikkat.los.service.UserService;


public class Utils {
	public static boolean tessss(String abc) {
		double a = new Double(abc);
		return false;
	}
	public static boolean CheckAuth(HashMap<String, Object> param) {
		String auth = "Basic MKqp!ncc2=Ix9Uy=";
		String platform = (String) param.get("platform");
		String authparam = (String) param.get("auth");
//		UserService userservice = (UserService) param.get("userservice");
		CompanyService companyservice = (CompanyService) param.get("companyservice");
		boolean flag = false;
		if(auth.equals(authparam)) {
			flag = true;
//			if(param.get("login") == null) {
//				if(platform.contains("-")) {
//					String[] ar = platform.split("\\-");
//					String compid = ar[0];
//					String userid = ar[1];
//					if(companyservice.findById(compid).isPresent()) {
//						Long id = 0L;
//						try {
//							id = new Long(userid);
//						}catch (Exception e) {
//							id = 0L;
//							// TODO: handle exception
//						}
//						Optional<UserEntity> oPtuser = userservice.findById(id.longValue());
//						if(oPtuser.isPresent()) {
//							UserEntity user = oPtuser.get();
//							if(user.getCompanyid().equals(compid)) {
//								flag = true;
//							}
//						}
//					}
//				}
//			}else {
//				flag = true;
//			}
		}
		return flag;
	}
	public static double convertByteToMB(double size) {
		return size / Math.pow(1024, 2);
	}
	public static Object SeparatorNumber(Object value) {
		DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

//        symbols.setGroupingSeparator(' ');
        formatter.setDecimalFormatSymbols(symbols);
		return formatter.format(value);
	}
	
	public static String getClientIp(HttpServletRequest request) {

        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }
	
	public static HashMap<String, Integer> GetPagination(int atPage,int sizepage) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int sizepageV1 = sizepage;
		int numberOfSizePage = 0;
		if(atPage > 1) {
			numberOfSizePage = sizepageV1 * (atPage+1);
			sizepageV1 = numberOfSizePage;
		}else {
			sizepageV1 = sizepageV1 * 2;
		}
		map.put("sizepage", sizepageV1);
		map.put("numberOfSizePage", numberOfSizePage);
		
		return map;
	}
	
	public static long GetRunningNumber(RunningNumberService service,String param) {
		long number = 0;
		RunningNumberEntity rn = service.getlistRunningNumberEntity(param);
		if(rn != null) {
			Optional<RunningNumberEntity> Opentity = service.findById(rn.getId());
			if(Opentity.isPresent()) {
				RunningNumberEntity entity = Opentity.get();
			    number = entity.getNumber();
				long tempnumber = number+1;
				entity.setNumber(tempnumber);
				service.create(entity);
			}else {
				number = new Long(String.valueOf(generateNumber())).longValue();
			}
		}else {
			number = new Long(String.valueOf(generateNumber())).longValue();
		}
		return number;
	}
	public static String RunningNumber2(String front,long number) {
		String value = "00000000"+number;
		if(number > 0 && number < 10) {
			value = "00000000"+number;
		}else if(number > 9) {
			value = "0000000"+number;
		}else if(number > 99) {
			value = "000000"+number;
		}else if(number > 999) {
			value = "00000"+number;
		}else if(number > 999) {
			value = "0000"+number;
		}else if(number > 9999) {
			value = "000"+number;
		}else if(number > 99999) {
			value = "00"+number;
		}else if(number > 999999) {
			value = "0"+number;
		}else if(number > 9999999) {
			value = number+"";
		}else {
			value = number+"";
		}
		value = front+value;
		return value;
	}
	public static String RunningNumber(long number) {
		String value = "00000000"+number;
		if(number > 0 && number < 10) {
			value = "00000000"+number;
		}else if(number > 9) {
			value = "0000000"+number;
		}else if(number > 99) {
			value = "000000"+number;
		}else if(number > 999) {
			value = "00000"+number;
		}else if(number > 999) {
			value = "0000"+number;
		}else if(number > 9999) {
			value = "000"+number;
		}else if(number > 99999) {
			value = "00"+number;
		}else if(number > 999999) {
			value = "0"+number;
		}else if(number > 9999999) {
			value = number+"";
		}else {
			value = number+"";
		}
		return value;
	}
	public static String namabulan(int index) {
		List<String> listbulan = new ArrayList<String>();
		listbulan.add("");
		listbulan.add("Januari");
		listbulan.add("Februari");
		listbulan.add("Maret");
		listbulan.add("April");
		listbulan.add("Mei");
		listbulan.add("Juni");
		listbulan.add("Juli");
		listbulan.add("Agustus");
		listbulan.add("September");
		listbulan.add("Oktober");
		listbulan.add("November");
		listbulan.add("Desember");		
		return listbulan.get(index);
	}
	public static String namabulan3(int index) {
		List<String> listbulan = new ArrayList<String>();
		listbulan.add("");
		listbulan.add("Jan");
		listbulan.add("Feb");
		listbulan.add("Mar");
		listbulan.add("Apr");
		listbulan.add("May");
		listbulan.add("Jun");
		listbulan.add("Jul");
		listbulan.add("Aug");
		listbulan.add("Sep");
		listbulan.add("Oct");
		listbulan.add("Nov");
		listbulan.add("Des");		
		return listbulan.get(index);
	}
	
	public static <Any> Any checkpresent(Optional<Any> op,Object obj) {
		Object tempobj = obj;
		if(op.isPresent()) {
			tempobj = op.get();
		}
		return ((Any)tempobj);
	}
	
	public static ZonedDateTime fromInstant(Instant i) {
		return i.atZone(ZoneId.systemDefault());
	}
	
	public static String zonedDateTimeToString(ZonedDateTime zd) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateFormatEnum.FORMAT_DATE_WITH_ZONE.value());
		String formattedString = zd.format(formatter);
		return formattedString;
	}
	
	public static ZonedDateTime stringToZonedDateTime(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateFormatEnum.FORMAT_DATE_WITH_ZONE.value());
		ZonedDateTime dateTime = ZonedDateTime.parse(date, formatter);
		return dateTime;
	}
	
	public static ZonedDateTime longToZonedDateTime(long dateLong) {
		ZonedDateTime  dateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(dateLong), ZoneId.systemDefault());
		return dateTime;
	}
	public static String pathOri() {
		return "http://localhost:2200";
	}
	public static int generateNumber(){
        int otp = 0;
        double min = 1;
        double max = 9999999;
        Double random = (Math.random()*((max-min)+1))+min;
        otp = random.intValue();
        return otp;
    }
	
	public static Date longToDate(long longdate) {
		Date dt = new Date(longdate);
		Date dt1 = new Date(longdate);
		SimpleDateFormat df2 = new SimpleDateFormat(DateFormatEnum.FORMAT_DATE.value());
		try {
			dt1 = df2.parse(df2.format(dt));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dt;
	}
	public static Date longToDate(long longdate,String format) {
		Date dt = new Date(longdate);
		Date dt1 = new Date(longdate);
		SimpleDateFormat df2 = new SimpleDateFormat(format);
		try {
			dt1 = df2.parse(df2.format(dt));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dt;
	}
	public static Date StringToDate(String strdate,String format) {
		Date dt = new Date();
		SimpleDateFormat df2 = new SimpleDateFormat(format);
		try {
			dt = df2.parse(strdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dt;
	}
	public static String DateToString(Date strdate,String format) {
		String date = "";
		SimpleDateFormat df2 = new SimpleDateFormat(format);
		date = df2.format(strdate);
		return date;
	}
	public static void createFolder(String path) {
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
	}
	public static Timestamp stringToTimestamp(String strdate,String format) {
		Date dt = new Date();
		SimpleDateFormat df2 = new SimpleDateFormat(format);
		try {
			dt = df2.parse(strdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Timestamp(dt.getTime());
	}
	
	public static String longDateToString(long strdate,String format) {
		Date dt = new Date(strdate);
		return DateToString(dt, format);
	}

	public static int calculateDateForAge(long dateofbirth) {
		if(dateofbirth > 0) {
			Date dt = new Date();
			Timestamp tsNow = new Timestamp(dt.getTime());
			long miliseconds = tsNow.getTime() - dateofbirth;
			Long days = TimeUnit.DAYS.convert(miliseconds, TimeUnit.MILLISECONDS) / 365;
			if(days > 0) {
				return days.intValue();
			}
		}

		return 0;
	}
}
