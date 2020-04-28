package com.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.UserPrincipal;
import com.practice.entity.Userdetails;
import com.practice.repository.UserDetailsRepo;

@Service
public class SecurityService implements UserDetailsService {

	@Autowired
	private UserDetailsRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Userdetails ud = userRepo.findByUserCode(userName);
		if (ud == null) {
			return (UserDetails) new UsernameNotFoundException("Username is not available");
		}
		return new UserPrincipal(ud);
	}
}