package com.j8.jodaapi;

import java.time.LocalDate;

public class FindDayMonthYear {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		
		int date = localDate.getDayOfMonth();
		int month = localDate.getMonthValue();
		int year = localDate.getYear();
		
		System.out.println("date is : "+date+" month is : "+month+" year is : "+year);
	}
}