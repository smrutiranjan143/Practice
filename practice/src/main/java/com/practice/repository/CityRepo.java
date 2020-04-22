package com.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.City;

public interface CityRepo extends JpaRepository<City, Integer> {
	public List<City> findByStateIdAndIsActive(Integer stateId, Integer isActive);
}