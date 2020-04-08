package com.j8.jodaapi;

import java.time.LocalDate;
import java.time.LocalTime;

public class DateAndTime {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println("Current date is : "+localDate);

		LocalTime localTime = LocalTime.now();
		System.out.println("Current time is : "+localTime);
	}
}