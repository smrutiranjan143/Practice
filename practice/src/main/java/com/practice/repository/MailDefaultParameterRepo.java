package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.MailDefaultParameter;

public interface MailDefaultParameterRepo extends JpaRepository<MailDefaultParameter, Integer> {

}