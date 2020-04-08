package com.practice.service;

import org.springframework.stereotype.Service;

import com.practice.entity.Country;

@Service
public interface MasterService {
	
	public Integer insertCountry(Country country);
}