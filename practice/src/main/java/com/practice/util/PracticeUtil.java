package com.practice.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

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

	public static int generateOtp() {
		int otp = 0;
		try {
			Random random = new Random();
			otp = random
					.nextInt((PracticeConstants.MAX_RANGE_GENERATE_OTP - PracticeConstants.MIN_RANGE_GENERATE_OTP) + 1)
					+ PracticeConstants.MIN_RANGE_GENERATE_OTP;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return otp;
	}
}