package com.example.UserMicroservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserMicroservice.Entity.User;
import com.example.UserMicroservice.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo ;
	
	public Boolean isUserPresent(Long userId) {
		// TODO Auto-generated method stub
		User user = userRepo.findById(userId).get() ;
		if(user == null) {
			return false ;
		}
		
		return true ;
	}

}
