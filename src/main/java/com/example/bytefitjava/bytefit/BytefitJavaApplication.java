package com.example.bytefitjava.bytefit;

import com.example.bytefitjava.bytefit.repository.FoodRepository;
import com.example.bytefitjava.bytefit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@SpringBootApplication
public class BytefitJavaApplication {

	@Autowired
	private FoodRepository foodRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(BytefitJavaApplication.class, args);
	}

}
