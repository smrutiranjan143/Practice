package com.practice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.MailDefaultEvent;

public interface MailDefaultEventRepo extends JpaRepository<MailDefaultEvent, Integer> {

	@Override
	Optional<MailDefaultEvent> findById(Integer id);
}