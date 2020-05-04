package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practice.entity.Otp;

public interface OtpRepo extends JpaRepository<Otp, String>{
	
	@Query("select o from Otp o where key = ?1 and otp = ?2")
	public Otp validateOtp(String key, Integer otp);

}
