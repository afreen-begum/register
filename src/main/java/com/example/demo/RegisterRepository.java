package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {
	public Optional<Register> findByemail(String email);
	public Register findByName(String name);
}
