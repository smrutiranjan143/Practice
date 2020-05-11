package com.practice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.practice.entity.City;
import com.practice.entity.Country;
import com.practice.entity.State;
import com.practice.exception.ServiceException;
import com.practice.service.MasterService;

@Controller
@RequestMapping(value = "/master")
public class MasterController {

	Logger logger = LoggerFactory.getLogger(MasterController.class);

	@Autowired
	private MasterService masterService;

	@PostMapping(value = "/saveCountry", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Integer insertCountry(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Country country) {
		Integer countryId = 0;
		try {
			countryId = masterService.insertCountry(country);
		} catch (ServiceException e) {
			logger.error("error", e);
		} catch (Exception ex) {
			logger.error("error", ex);
		}
		return countryId;
	}
	
	@GetMapping(value = "/getCountries/{isActive}")
	@ResponseBody
	public String getCountriesByIsActive(HttpServletRequest request, HttpServletResponse response, 
			@PathVariable("isActive") Integer isActive){
		
		String countries = null;
		try {
			Gson gson = new Gson();
			countries = gson.toJson(masterService.getCountries(isActive));
			
		}catch (Exception e) {
		}
		return countries;
		
	}
	
	
	@PostMapping(value ="/saveState",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Integer insertState(HttpServletRequest request, HttpServletResponse response, 
			@RequestBody State state) {
		Integer stateId = 0;
		try {
			stateId = masterService.insertState(state);
		}catch (Exception e) {
		}
				return stateId;
		
	}

	@GetMapping(value = "/getStates/{countryId}")
	@ResponseBody
	public String getStatesByCountryId(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("countryId") Integer countryId) {
		String states = null;
		try {
			Gson gson = new Gson();
			states = gson.toJson(masterService.getStates(countryId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return states;
	}
	
	@PostMapping(value = "/saveCity", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Integer insertCity(HttpServletRequest request, HttpServletResponse reponse,
			@RequestBody City city) {
		Integer cityId = 0;
		try {
			cityId = masterService.insertCity(city);
		}catch (Exception e) {
		}
		return cityId;
	}
	
	@GetMapping(value = "/getCities/{stateId}")
	@ResponseBody
	public String getCitiesByStateId(HttpServletRequest request, HttpServletResponse response,
			@PathVariable("stateId")Integer stateId){
		String cities = null;
		try {
			Gson gson = new Gson();
			cities = gson.toJson(masterService.getCities(stateId));
			
		}catch (Exception e) {
		}
		return cities;
		
	}
}