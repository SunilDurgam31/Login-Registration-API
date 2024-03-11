package com.example.instructor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.instructor.models.Register;
import com.example.instructor.services.RegisterService;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*") 
public class RegisterController {

    @Autowired
    private RegisterService serv;

    @GetMapping("/")
    public ResponseEntity<List<Register>> GetAllRegister() {
        try {
            List<Register> registers = serv.GetAllRegister();
            return ResponseEntity.status(HttpStatus.OK).body(registers);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Register> getRegister(@PathVariable int id) {
        try {
            Register register = serv.getRegisterById(id);
            return ResponseEntity.status(HttpStatus.OK).body(register);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    
    @PostMapping("/register")
    public ResponseEntity<Register> addRegister(@RequestBody Register register) {
        try {
            Optional<Register> existingUser = serv.findByEmail(register.getEmail());
            if (existingUser.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); 
            }
            Register savedRegister = serv.addRegister(register);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedRegister);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    
    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<?> loginUser(@RequestBody Register loginUser) {
        try {
            Optional<Register> existingUser = serv.findByEmailAndPassword(loginUser.getEmail(), loginUser.getPassword());
            if (existingUser.isPresent()) {
                return ResponseEntity.ok(existingUser.get());
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

    
    @PutMapping("/update")
    public ResponseEntity<Register> updateRegister(@RequestBody Register register) {
        try {
            Register updatedRegister = serv.updateRegister(register);
            return ResponseEntity.status(HttpStatus.OK).body(updatedRegister);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRegister(@PathVariable int id) {
        try {
            serv.deleteRegister(serv.getRegisterById(id));
            return ResponseEntity.ok("Deleted");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}