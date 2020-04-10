package com.practice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dto.UserDTO;
import com.practice.entity.Userdetails;
import com.practice.exception.ServiceException;
import com.practice.repository.UserDetailsRepo;
import com.practice.service.UserService;
import com.practice.util.PracticeConstants;
import com.practice.util.PracticeUtil;

@Service
public class UserdetailsServiceImpl implements UserService {

	Logger logger = LoggerFactory.getLogger(UserdetailsServiceImpl.class);

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
			//send mail to user after registration
			//start
			
			//end
			userId = userdetails.getUserId();
		} catch (ServiceException ex) {
			logger.error("error", ex);
		} catch (Exception ex) {
			logger.error("error", ex);
		}
		return userId;
	}

	private void sendMailToUserOnRegistration(UserDTO userDTO) {

	}
}