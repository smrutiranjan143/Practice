package com.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.State;

public interface StateRepo extends JpaRepository<State, Integer> {
	public List<State> findByCountryIdAndIsActive(Integer countryId, Integer isActive);
}