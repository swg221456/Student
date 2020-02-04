package util;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReturnDate {
	/**
	 * 返回时间样式yyyy-MM-dd HH:mm:ss
	 * @param datetime
	 * @return
	 */
	public static String datetimeFormat(String datetime){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date;
		try {
			date = df.parse(datetime);
			String s = df.format(date);
			return s;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datetime;
	}
	
	
	public static String tranDate2datetime(Date d){
		Format f= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String s = f.format(d);
		return s;
	}
	
	/**
	 * 返回时间样式yyyy-MM-dd HH:mm
	 * @param datetime
	 * @return
	 */
	public static String datetimeFormatnoscen(String datetime){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date;
		try {
			date = df.parse(datetime);
			String s = df.format(date);
			return s;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datetime;
	}
	
	/**
	 * 返回时间格式yyyy-MM-dd
	 * @param datetime
	 * @return
	 */
	public static String datetimeFormatnotime(String datetime){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = df.parse(datetime);
			String s = df.format(date);
			return s;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datetime;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 返回时间格式yyyy-MM
	 * @param datetime
	 * @return
	 */
	public static String datetimeFor(String datetime){
		DateFormat df = new SimpleDateFormat("yyyy-MM");
		Date date;
		try {
			date = df.parse(datetime);
			String s = df.format(date);
			return s;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datetime;
	}
	
}
