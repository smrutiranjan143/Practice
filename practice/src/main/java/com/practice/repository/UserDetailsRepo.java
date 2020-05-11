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
	
	public Userdetails findByUserCodeAndPasswordAndIsActive(String userCode, String password, Integer IsActive);
	
	@Transactional
	@Query("select u from Userdetails u where email = :email")
	public Userdetails forgotPassword(@Param("email")String email);
	
	@Transactional
	@Modifying
	@Query("update Userdetails u set u.password = :new_password where u.password = :password")
	public Integer updatePassword(@Param("password")String password, @Param("new_password")String newPassword);
	
	
	@Transactional
	@Modifying
	@Query("delete from Userdetails u where isActive = :isActive")
	public void deleteUserdetails(@Param("isActive") Integer isActive);
}