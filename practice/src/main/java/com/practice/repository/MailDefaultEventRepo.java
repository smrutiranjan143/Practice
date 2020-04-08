package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.MailDefaultEvent;

public interface MailDefaultEventRepo extends JpaRepository<MailDefaultEvent, Integer> {

}