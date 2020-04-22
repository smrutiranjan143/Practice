package com.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.Country;
import com.practice.entity.State;
import com.practice.repository.CountryRepo;
import com.practice.repository.StateRepo;
import com.practice.service.MasterService;
import com.practice.util.PracticeConstants;
import com.practice.util.PracticeLogging;

@Service
public class MasterServiceImpl implements MasterService {

	private static final PracticeLogging logger = PracticeLogging.getLogger(MasterServiceImpl.class);

	@Autowired
	private CountryRepo countryRepo;

	@Autowired
	private StateRepo stateRepo;

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

	@Override
	public List<State> getStates(Integer countryId) {
		List<State> states = null;
		try {
			Integer status = PracticeConstants.ACTIVE_ROW;
			states = stateRepo.findByCountryIdAndIsActive(countryId,status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return states;
	}
}