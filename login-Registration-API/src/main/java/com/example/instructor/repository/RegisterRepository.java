package com.example.instructor.repository;

import java.util.List;
//import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.instructor.models.Register;

public interface RegisterRepository extends JpaRepository<Register , Integer> {
	@Query("SELECT r FROM Register r WHERE r.email = :email AND r.password = :password")
	List<Register> findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
	}
