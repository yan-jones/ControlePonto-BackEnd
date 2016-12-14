package br.com.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtil {

	public static String formatDataHoraBr(Date date) {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formatador.format(date);
	}

	public static Calendar parseStringToCalendar(String data) {
		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			calendar.setTime(formatador.parse(data.toString()));
			return calendar;
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public static Calendar parseStringToCalendarWithHours(String data) {
		try {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
			calendar.setTime(formatador.parse(data));
			return calendar;
		} catch (ParseException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public static Calendar parseStringDateBrToCalendar(String data) {

		try {

			Calendar calendar = Calendar.getInstance();

			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			calendar.setTime(formatter.parse(data));
			calendar.add(Calendar.MONTH, 1);

			return calendar;

		} catch (ParseException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
