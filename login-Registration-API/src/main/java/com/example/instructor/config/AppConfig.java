package com.example.instructor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.instructor.services.RegisterService;
import com.example.instructor.services.RegisterServiceImp;

@Configuration
public class AppConfig {
	
	@Bean
	public RegisterService getRegistorRepository()
	{
		return new RegisterServiceImp();
	}
}

