package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.State;

public interface StateRepo extends JpaRepository<State, Integer> {

}