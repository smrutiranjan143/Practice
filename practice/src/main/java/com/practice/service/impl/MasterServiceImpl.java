package com.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.entity.City;
import com.practice.entity.Country;
import com.practice.entity.State;
import com.practice.repository.CityRepo;
import com.practice.repository.CountryRepo;
import com.practice.repository.StateRepo;
import com.practice.service.MasterService;
import com.practice.util.PracticeConstants;

@Service
public class MasterServiceImpl implements MasterService {

	@Autowired
	private CountryRepo countryRepo;

	@Autowired
	private StateRepo stateRepo;
	
	@Autowired
	private CityRepo cityRepo;

	@Override
	public Integer insertCountry(Country country) {
		Integer countryId = null;
		try {
			country = countryRepo.save(country);
			if (country != null) {
				countryId = country.getCountryId();
			}
		} catch (Exception e) {
		}
		return countryId;
	}
	
	@Override
	public List<Country> getCountries(Integer isActive) {
		List<Country> countries = null;
		try {
			Integer status = PracticeConstants.ACTIVE_ROW;
			countries = countryRepo.getCountries(status);
		}catch (Exception e) {
		}
		return countries;
	}

	@Override
	public Integer insertState(State state) {
		Integer stateId = null;
		try {
			state = stateRepo.save(state);
			if(state != null) {
				stateId = state.getStateId();
			}
			
		}catch (Exception e) {
		}
		return stateId;
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

	@Override
	public Integer insertCity(City city) {
		Integer cityId = null;
		try {
			city = cityRepo.save(city);
			if(city != null) {
				cityId = city.getCityId();
			}
		}catch (Exception e) {
		}
		return cityId;
	}

	@Override
	public List<City> getCities(Integer stateId) {
		List<City> cities = null;
		try {
			Integer status = PracticeConstants.ACTIVE_ROW;
			cities = cityRepo.findByStateIdAndIsActive(stateId, status);
			
		}catch (Exception e) {
		}
		return cities;
	}
	
}