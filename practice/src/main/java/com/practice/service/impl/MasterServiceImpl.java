package com.practice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.Country;
import com.practice.repository.CountryRepo;
import com.practice.service.MasterService;

@Service
public class MasterServiceImpl implements MasterService {

	Logger logger = LoggerFactory.getLogger(MasterService.class);

	@Autowired
	private CountryRepo countryRepo;

	@Override
	public Integer insertCountry(Country country) {
		Integer countryId = null;
		try {
			country = countryRepo.save(country);
			if (country != null) {
				countryId = country.getCountryId();
			}
		} catch (Exception e) {
			logger.error("error", e);
		}
		return countryId;
	}
}