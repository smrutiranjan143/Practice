package com.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practice.entity.City;

public interface CityRepo extends JpaRepository<City, Integer> {
	@Query("select c from City c where c.isActive = 1")
	public List<City> findByStateId(Integer stateId);
}