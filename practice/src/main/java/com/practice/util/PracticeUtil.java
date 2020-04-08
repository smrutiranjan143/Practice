package com.practice.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class PracticeUtil {
	
	public static LocalDate getCurrentDate() {
		return LocalDate.now();
	}
	
	public static LocalTime getCurrentTime() {
		return LocalTime.now();
	}
	
	public static LocalDateTime getCurrentDateTime() {
		return LocalDateTime.now();
	}
}