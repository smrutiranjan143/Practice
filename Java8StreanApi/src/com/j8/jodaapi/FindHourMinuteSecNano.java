package com.j8.jodaapi;

import java.time.LocalTime;

public class FindHourMinuteSecNano {
	public static void main(String[] args) {
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);

		int hour = localTime.getHour();
		int minute = localTime.getMinute();
		int second = localTime.getSecond();
		int nanoSecond = localTime.getNano();

		System.out.println("hour is : " + hour + " minute is : " + minute + " second is : " + second
				+ " nano second is : " + nanoSecond);
	}
}