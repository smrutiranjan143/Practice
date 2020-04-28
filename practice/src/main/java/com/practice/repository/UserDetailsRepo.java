package com.practice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.Userdetails;

public interface UserDetailsRepo extends JpaRepository<Userdetails, Integer> {
	public List<Userdetails> findByIsActive(Integer isActive);
	
	public Userdetails findByUserCode(String userCode);
}