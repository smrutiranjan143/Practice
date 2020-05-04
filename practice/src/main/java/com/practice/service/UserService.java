package com.practice.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.practice.dto.UserDTO;
import com.practice.entity.Userdetails;

@Service
public interface UserService {
	public Integer insertUser(UserDTO userDTO);
	public Map<String, Object> getAllUserCode();
	
	public Userdetails getUserByEmail(String email);
	
	public void sendMailAfterSuccessRegistration(Userdetails userDetails);
	
	public Integer updateUserdetails(Integer userId, Integer isActive);
}