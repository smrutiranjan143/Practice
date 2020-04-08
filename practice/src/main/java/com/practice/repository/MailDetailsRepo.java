package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.MailDetails;

public interface MailDetailsRepo extends JpaRepository<MailDetails, Integer> {

}