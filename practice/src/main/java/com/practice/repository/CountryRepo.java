package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.Country;

public interface CountryRepo extends JpaRepository<Country, Integer> {
}