package com.example.Security;

import com.example.Security.security.JwtTokenProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityApplication  {

	public static void main (String[] args)  {
		SpringApplication.run(SecurityApplication.class, args);
		JwtTokenProvider jwtTokenProvider= new JwtTokenProvider();
		String token= jwtTokenProvider.maHoaDuLieu2("long", "admin");
		System.out.println("token:"+ token);
	}

}
