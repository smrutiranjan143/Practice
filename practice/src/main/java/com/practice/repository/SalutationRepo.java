package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.Salutation;

public interface SalutationRepo extends JpaRepository<Salutation, Integer> {
}