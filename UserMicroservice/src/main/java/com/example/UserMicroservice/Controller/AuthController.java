package com.example.UserMicroservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.UserMicroservice.DTO.*;
import com.example.UserMicroservice.Service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService ;
	
	@PostMapping("/signup")
	public ResponseMessage signup(@RequestBody @Valid SignupRequest request) {
		return authService.register(request) ;
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
		 return new ResponseEntity<>(authService.login(request), HttpStatus.OK) ;
	} 
}
