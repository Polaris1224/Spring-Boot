package com.example.UserMicroservice.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
	String username ;
	String password ;
}
