package com.practice.service;

import org.springframework.stereotype.Service;

import com.practice.dto.UserDTO;

@Service
public interface UserService {
	public Integer insertUser(UserDTO userDTO);
}