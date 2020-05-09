package com.practice.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.practice.dto.AddressDTO;
import com.practice.dto.UserDTO;
import com.practice.entity.Userdetails;

@Service
public interface UserService {
	public Integer insertUser(UserDTO userDTO);
	public Map<String, Object> getAllUserCode();
	
	public Userdetails getUserByEmail(String email);
	
	public void sendMailAfterSuccessRegistration(Userdetails userDetails);
	
	public Integer updateUserdetails(Integer userId, Integer isActive);
	
	public Userdetails loggedInUser(String userCode, String password);
	
	public Userdetails getUserAndPasswordByEmail(String email);
	
	public void sendMailForForgotPassword(Userdetails userDetails);
	
	public Integer resetPassword(String password, String newPassword); 
	
	public Integer insertAddress(AddressDTO addressDTO);
	
	
}