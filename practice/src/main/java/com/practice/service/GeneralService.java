package com.practice.service;

import org.springframework.stereotype.Service;

import com.practice.entity.Otp;

@Service
public interface GeneralService {
	public Otp insertOtp(String mobile);
	
	public void validateOtp(String email, Integer otp);
}
