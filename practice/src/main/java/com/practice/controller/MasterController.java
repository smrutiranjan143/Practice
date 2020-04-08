package com.practice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.entity.Country;
import com.practice.exception.ServiceException;
import com.practice.service.MasterService;

@Controller
@RequestMapping(value = "/master")
public class MasterController {

	Logger logger = LoggerFactory.getLogger(MasterController.class);

	@Autowired
	private MasterService masterService;

	@PostMapping(value = "/saveCountry")
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
}