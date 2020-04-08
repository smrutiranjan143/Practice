package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.Zip;

public interface ZipRepo extends JpaRepository<Zip, Integer> {

}