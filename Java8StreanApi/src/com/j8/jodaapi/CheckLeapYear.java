package com.j8.jodaapi;

import java.time.Year;

public class CheckLeapYear {
	public static void main(String[] args) {
		int n = 2021;
		Year y = Year.of(n);
		if(y.isLeap()) {
			System.out.println("This is a leap year");
		}else {
			System.out.println("This is not a leap year");
		}
	}
}