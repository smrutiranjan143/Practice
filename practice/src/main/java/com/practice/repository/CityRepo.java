package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.City;

public interface CityRepo extends JpaRepository<City, Integer> {

}