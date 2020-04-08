package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Integer> {

}