package com.practice.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practice.entity.Userdetails;

public interface UserDetailsRepo extends JpaRepository<Userdetails, Integer> {
	public List<Userdetails> findByIsActive(Integer isActive);
	
	public Userdetails findByUserCode(String userCode);

	public Userdetails findByEmailAndIsActive(String email, Integer isActive);
	
	@Transactional
	@Modifying
	@Query("update Userdetails ud set ud.isActive = :isActive where ud.userId = :userId")
	public Integer updateUserdetails(@Param("userId") Integer userId, @Param("isActive") Integer isActive);
}