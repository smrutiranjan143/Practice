package com.j8.jodaapi;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author SmrutiRaj Period object represent the quantity of time
 */
public class PeriodObject {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		LocalDate birthDate = LocalDate.of(1995, 02, 17);

		Period period = Period.between(birthDate, today);
		System.out.println("Remaining days is : " + period.getDays() + " days " + period.getMonths() + " months and "
				+ period.getYears() + " years");
	}
}