package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.Userdetails;

public interface UserDetailsRepo extends JpaRepository<Userdetails, Integer> {

}