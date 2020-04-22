package com.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.Zip;

public interface ZipRepo extends JpaRepository<Zip, Integer> {
	public List<Zip> findByCityIdAndIsActive(Integer zipId,Integer isActive);
}