package com.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.practice.entity.State;

public interface StateRepo extends JpaRepository<State, Integer> {
	@Query("select s from State s where s.countryId = ?1 and s.isActive = ?2")
	public List<State> findByCountryId(Integer countryId,Integer status);
}