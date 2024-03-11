package com.example.instructor.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.instructor.models.Register;
import com.example.instructor.repository.RegisterRepository;

public class RegisterServiceImp  implements RegisterService {

	@Autowired
	private RegisterRepository repo;
	
	@Override
	public List<Register> GetAllRegister() {
		return repo.findAll();
	}

	@Override
	public Register addRegister(Register reg) {
		return repo.save(reg);
	}

	@Override
	public Register updateRegister(Register reg) {
		return repo.save(reg);
	}

	@Override
	public void deleteRegister(Register reg) {
		repo.delete(reg);

	}

	@Override
	public Register getRegisterById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public Optional<Register> findByEmail(String email) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void save(Register regRes) {
		// TODO Auto-generated method stub
		
	}

	public Optional<Register> findByEmailAndPassword(String email, String password) {
	    List<Register> results = repo.findByEmailAndPassword(email, password);
	    if (results.size() == 1) {
	        return Optional.of(results.get(0));
	    } else if (results.isEmpty()) {
	        return Optional.empty();
	    } else {
	        
	        throw new IllegalStateException("User Exist");
	    }
	}
	
}


