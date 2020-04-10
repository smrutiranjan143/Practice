package com.practice.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dto.UserDTO;
import com.practice.entity.Userdetails;
import com.practice.exception.ServiceException;
import com.practice.repository.UserDetailsRepo;
import com.practice.service.MailService;
import com.practice.service.UserService;
import com.practice.util.PracticeConstants;
import com.practice.util.PracticeUtil;

@Service
public class UserdetailsServiceImpl implements UserService {

	Logger logger = LoggerFactory.getLogger(UserdetailsServiceImpl.class);

	// This is for service
	@Autowired
	private MailService mailService;

	// This is for repo
	@Autowired
	private UserDetailsRepo userdetailsRepo;

	@Override
	public Integer insertUser(UserDTO userDTO) {
		Integer userId = 0;
		try {
			Userdetails userdetails = new Userdetails();
			userdetails.setUserCode(userDTO.getUserCode());
			userdetails.setPassword(userDTO.getPassword());
			// userdetails.setSalutationId(userDTO.getSalutation());
			userdetails.setFirstName(userDTO.getFirstName());
			userdetails.setMiddleName(userDTO.getMiddleName());
			userdetails.setLastName(userDTO.getLastName());
			userdetails.setEmail(userDTO.getEmail());
			userdetails.setMobileNo(userDTO.getMobile());
			userdetails.setCreateId(PracticeConstants.DEFAULT_CREATE_ID);
			userdetails.setCreateDate(PracticeUtil.getCurrentDateTime());
			userdetails.setUpdateId(PracticeConstants.DEFAULT_CREATE_ID);
			userdetails.setUpdateDate(PracticeUtil.getCurrentDateTime());
			userdetails.setIsActive(PracticeConstants.ACTIVE_ROW);

			userdetails = userdetailsRepo.save(userdetails);
			// send mail to user after registration
			// start
			sendMailToUserOnRegistration(userdetails);
			// end
			userId = userdetails.getUserId();
		} catch (ServiceException ex) {
			logger.error("error", ex);
		} catch (Exception ex) {
			logger.error("error", ex);
		}
		return userId;
	}

	private void sendMailToUserOnRegistration(Userdetails userDetails) {
		Map<String, Object> mapMailInfo = new HashMap<>();
		Map<String, Object> mapMailParameterInfo = new HashMap<>();
		String[] mailCc = null;
		String[] mailBcc = null;
		try {
			mapMailInfo.put(PracticeConstants.MAIL_EVENT_ID, PracticeConstants.MAIL_EVENT_ON_USER_REGISTRATION);
			mapMailInfo.put(PracticeConstants.MAIL_TO, userDetails.getEmail());
			mapMailInfo.put(PracticeConstants.MAIL_CC, mailCc);
			mapMailInfo.put(PracticeConstants.MAIL_BCC, mailBcc);
			mapMailInfo.put(PracticeConstants.MAIL_USER_ID, userDetails.getUserId());

			mailService.sendMail(mapMailInfo, mapMailParameterInfo);
		} catch (Exception ex) {
			logger.error("error in sending mail");
		}
	}
}