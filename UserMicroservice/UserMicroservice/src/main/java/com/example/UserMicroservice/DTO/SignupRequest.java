package com.example.UserMicroservice.DTO;

import java.util.Set;

import com.example.UserMicroservice.Entity.Role;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignupRequest {
	
	private String username ;
	private String email ;
	private String password ;
	private Set<Role> roles ;
}
