package com.example.instructor.services;

import java.util.List;
import java.util.Optional;

import com.example.instructor.models.Register;

public interface RegisterService {

	public List<Register> GetAllRegister();
	public Register addRegister(Register reg);
	public Register updateRegister(Register reg);
	public void deleteRegister(Register reg);
	public Register getRegisterById(int id);
	public Optional<Register> findByEmail(String email);
	public void save(Register regRes);
	Optional<Register> findByEmailAndPassword(String email, String password);


	
}
