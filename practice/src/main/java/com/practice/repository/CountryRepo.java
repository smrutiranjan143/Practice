package com.practice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practice.entity.Country;

public interface CountryRepo extends JpaRepository<Country, Integer> {
	
	@Transactional
	@Query("select c from Country c where isActive = :isActive")
	public List<Country> getCountries(@Param("isActive") Integer isActive);
}