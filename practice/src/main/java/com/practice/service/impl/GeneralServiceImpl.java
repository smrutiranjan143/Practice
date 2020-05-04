package com.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.Otp;
import com.practice.entity.Userdetails;
import com.practice.repository.OtpRepo;
import com.practice.service.GeneralService;
import com.practice.service.UserService;
import com.practice.util.PracticeConstants;
import com.practice.util.PracticeUtil;

@Service
public class GeneralServiceImpl implements GeneralService {

	@Autowired
	private OtpRepo otpRepo;

	@Autowired
	private UserService userService;

	@Override
	public Otp insertOtp(String mobile) {
		Otp otp = new Otp();
		otp.setKey(mobile);
		otp.setOtp(PracticeUtil.generateOtp());
		otp.setCreateDate(PracticeUtil.getCurrentDateTime());

		return otpRepo.save(otp);
	}

	@Override
	public void validateOtp(String email, Integer otp) {
		Otp otp2 = otpRepo.validateOtp(email, otp);
		if (otp2 != null) {
			Userdetails ud = userService.getUserByEmail(email);
			if (ud != null) {
				userService.updateUserdetails(ud.getUserId(), PracticeConstants.ACTIVE_ROW);
			}
			userService.sendMailAfterSuccessRegistration(ud);
		}
	}
}
