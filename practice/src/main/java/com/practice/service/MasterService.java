package com.practice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.entity.Country;
import com.practice.entity.State;

@Service
public interface MasterService {
	
	public Integer insertCountry(Country country);
	
	public List<State> getStates(Integer countryId);
}