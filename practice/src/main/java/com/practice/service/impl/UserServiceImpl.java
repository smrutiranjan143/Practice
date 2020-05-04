package com.practice.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.practice.dto.UserDTO;
import com.practice.entity.Otp;
import com.practice.entity.Salutation;
import com.practice.entity.Userdetails;
import com.practice.exception.ServiceException;
import com.practice.repository.SalutationRepo;
import com.practice.repository.UserDetailsRepo;
import com.practice.service.GeneralService;
import com.practice.service.MailService;
import com.practice.service.UserService;
import com.practice.util.PracticeConstants;
import com.practice.util.PracticeUtil;

@Service
public class UserServiceImpl implements UserService {
	
	// This is for service
	@Autowired
	private MailService mailService;

	@Autowired
	private GeneralService generalService;

	// This is for repo
	@Autowired
	private UserDetailsRepo userdetailsRepo;

	@Autowired
	private SalutationRepo salutationRepo;

	@Override
	public Integer insertUser(UserDTO userDTO) {
		Integer userId = 0;
		try {
			Userdetails userdetails = new Userdetails();
			userdetails.setUserCode(userDTO.getUserCode());
			userdetails.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
			userdetails.setSalutationId(userDTO.getSalutationId());
			userdetails.setFirstName(userDTO.getFirstName());
			userdetails.setMiddleName(userDTO.getMiddleName());
			userdetails.setLastName(userDTO.getLastName());
			userdetails.setEmail(userDTO.getEmail());
			userdetails.setMobileNo(userDTO.getMobile());
			userdetails.setCreateId(PracticeConstants.DEFAULT_CREATE_ID);
			userdetails.setCreateDate(PracticeUtil.getCurrentDateTime());
			userdetails.setUpdateId(PracticeConstants.DEFAULT_CREATE_ID);
			userdetails.setUpdateDate(PracticeUtil.getCurrentDateTime());
			userdetails.setIsActive(PracticeConstants.INACTIVE_ROW);

			userdetails = userdetailsRepo.save(userdetails);

			// generate otp for validation
			Otp otp = generalService.insertOtp(userdetails.getEmail());

			// send mail to user after registration
			// start
			sendMailToUserforOtpValidation(userdetails.getEmail(), otp.getOtp());
			// end
			userId = userdetails.getUserId();
		} catch (ServiceException ex) {
		} catch (Exception ex) {
		}
		return userId;
	}

	private void sendMailToUserforOtpValidation(String email, Integer otp) {
		Map<String, Object> mapMailInfo = new HashMap<>();
		Map<String, Object> mapMailParameterInfo = new HashMap<>();
		try {
			mapMailInfo.put(PracticeConstants.MAIL_EVENT_ID, PracticeConstants.MAIL_OTP);
			mapMailInfo.put(PracticeConstants.MAIL_TO, email);
			mapMailInfo.put(PracticeConstants.MAIL_CC, null);
			mapMailInfo.put(PracticeConstants.MAIL_BCC, null);

			mapMailParameterInfo.put(PracticeConstants.OTP, otp);

			mailService.tryToSendMail(mapMailInfo, mapMailParameterInfo);
		} catch (Exception ex) {
		}
	}

	@Override
	public Map<String, Object> getAllUserCode() {
		Map<String, Object> mapIsActive = new HashMap<>();
		try {
			List<Userdetails> userDetails = userdetailsRepo.findByIsActive(PracticeConstants.ACTIVE_ROW);
			if (userDetails != null && userDetails.size() > 0) {
				for (Userdetails user : userDetails) {
					mapIsActive.put(user.getUserCode(), user);
				}
			}
		} catch (Exception e) {
		}
		return mapIsActive;
	}

	@Override
	public Userdetails getUserByEmail(String email) {
		Integer isActive = PracticeConstants.INACTIVE_ROW;
		Userdetails ud = userdetailsRepo.findByEmailAndIsActive(email, isActive);
		return ud;
	}

	@Override
	public Integer updateUserdetails(Integer userId, Integer isActive) {
		return userdetailsRepo.updateUserdetails(userId, isActive);
	}

	@Override
	public void sendMailAfterSuccessRegistration(Userdetails userDetails) {
		StringBuilder sb = new StringBuilder();
		Map<String, Object> mapMailInfo = new HashMap<>();
		Map<String, Object> mapMailParameterInfo = new HashMap<>();
		
		mapMailInfo.put(PracticeConstants.MAIL_EVENT_ID, PracticeConstants.MAIL_EVENT_ON_USER_REGISTRATION);
		mapMailInfo.put(PracticeConstants.MAIL_TO, userDetails.getEmail());
		mapMailInfo.put(PracticeConstants.MAIL_CC, null);
		mapMailInfo.put(PracticeConstants.MAIL_BCC, null);

		if (userDetails.getSalutationId() != null && userDetails.getSalutationId() > 0) {
			Salutation salutation = salutationRepo.findById(userDetails.getSalutationId()).orElse(null);
			sb.append(salutation.getSalutationValue());
		}
		if (userDetails.getFirstName() != null && !userDetails.getFirstName().isEmpty()) {
			sb.append(PracticeConstants.SPACE).append(userDetails.getFirstName());
		}
		if (userDetails.getMiddleName() != null && !userDetails.getMiddleName().isEmpty()) {
			sb.append(PracticeConstants.SPACE).append(userDetails.getMiddleName());
		}
		if (userDetails.getLastName() != null && !userDetails.getLastName().isEmpty()) {
			sb.append(PracticeConstants.SPACE).append(userDetails.getLastName());
		}
		
		mapMailParameterInfo.put(PracticeConstants.USER_FULL_NAME, sb.toString());
		mailService.tryToSendMail(mapMailInfo, mapMailParameterInfo);
	}
}