package com.example.UserMicroservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.UserMicroservice.DTO.LoginRequest;
import com.example.UserMicroservice.DTO.LoginResponse;
import com.example.UserMicroservice.DTO.ResponseMessage;
import com.example.UserMicroservice.DTO.SignupRequest;
import com.example.UserMicroservice.Entity.User;
import com.example.UserMicroservice.JWT.JwtAuthenticationHelper;
import com.example.UserMicroservice.Repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class AuthService {

	@Autowired
	private AuthenticationManager authManager ;
	
	@Autowired
	private JwtAuthenticationHelper jwtHelper ;
	
	@Autowired
	private UserDetailsService userDetailsService ;
	
	@Autowired
	private UserRepository userRepo ;
	
	
	public LoginResponse login(@Valid LoginRequest request) {
		// TODO Auto-generated method stub
		this.doAuthenticate(request.getUsername(), request.getPassword()) ;
		UserDetails userDetials = userDetailsService.loadUserByUsername(request.getUsername()) ;
		String token = jwtHelper.generateToken(userDetials) ;
		LoginResponse response = LoginResponse.builder()
											  .token(token)
											  .build();
		return response ;
	}

	private void doAuthenticate(String username, String password) {
		// TODO Auto-generated method stub
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password) ;
		try {
			authManager.authenticate(authToken) ;
		}catch(Exception e) {
			throw new BadCredentialsException("Incorrect User name.") ;
		}
	}

	public ResponseMessage register(@Valid SignupRequest request) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder() ;
		User user = User.builder()
						.username(request.getUsername())
						.email(request.getEmail())
						.password(encoder.encode(request.getPassword()))
						.roles(request.getRoles())
						.build();
		
		userRepo.save(user) ;
		return new ResponseMessage("User created Successfully") ;
	}

}
