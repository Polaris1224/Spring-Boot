package com.example.UserMicroservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserMicroservice.Service.UserService;

@RestController
@RequestMapping("/application/user")
public class UserController {

	@Autowired
	private UserService userService ;
	
	@GetMapping("getUser/{userId}")
	public ResponseEntity<Boolean> isUserPresent(@PathVariable Long userId) {
		return ResponseEntity.ok(userService.isUserPresent(userId)) ;
	}
}
