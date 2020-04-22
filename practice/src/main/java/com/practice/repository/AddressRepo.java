package com.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {
	public List<Address> findByUserIdAndIsActive(Integer userId, Integer isActive);
}