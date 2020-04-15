package com.practice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.Country;
import com.practice.repository.CountryRepo;
import com.practice.service.MasterService;
import com.practice.util.PracticeLogging;

@Service
public class MasterServiceImpl implements MasterService {

	private static final PracticeLogging logger = PracticeLogging.getLogger(MasterServiceImpl.class);

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