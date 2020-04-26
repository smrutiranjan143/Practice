package com.practice.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.practice.dto.UserDTO;

@Service
public interface UserService {
	public Integer insertUser(UserDTO userDTO);
	public Map<String, Object> getAllUserCode();
}
