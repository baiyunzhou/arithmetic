package com.zby;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class BanaryWatch {

	public static void main(String[] args) throws Exception {
		for (int i = 0; i < 10000000; i++) {
			Calendar calendar = Calendar.getInstance();
			int hour = calendar.get(Calendar.HOUR_OF_DAY);
			int minute = calendar.get(Calendar.MINUTE);
			int second = calendar.get(Calendar.SECOND);
			System.out.println("now:" + getBinary(hour) + ":" + getBinary(minute) + ":" + getBinary(second));
			TimeUnit.SECONDS.sleep(1);
		}
	}

	public static String getBinary(int val) {
		String binaryString = Integer.toBinaryString(val);
		int length = binaryString.length();
		if (length < 6) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 6 - length; i++) {
				sb.append("0");
			}
			sb.append(binaryString);
			return sb.toString();
		}
		return binaryString;
	}
}
