package com.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.Userdetails;
import com.practice.repository.UserDetailsRepo;
import com.practice.service.CronService;
import com.practice.util.PracticeConstants;

@Service
public class CronServiceImpl implements CronService{
	
	@Autowired
	private UserDetailsRepo userRepo;

	@Override
	public void deleteUserdetails() {
		Integer isActive = PracticeConstants.INACTIVE_ROW;
		List<Userdetails> ud = (List<Userdetails>) userRepo.findByIsActive(isActive);
		for(Userdetails u : ud) {
			userRepo.deleteById(u.getUserId());
			System.out.println("Delete User is " + u.getUserId() + " and UserName is "+ u.getUserCode());
		}
	}

}
