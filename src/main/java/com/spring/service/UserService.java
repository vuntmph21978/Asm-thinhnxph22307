package com.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Products;
import com.spring.entity.Users;
import com.spring.repository.UsersRepository;


@Service
public class UserService {
	
	    @Autowired
	    private UsersRepository userRepository;

	    public void register(Users user) {
	        userRepository.save(user);
	    }

//	    public boolean userNameExists(String usersname) {
//	        Users user = userRepository.findByUsername(usersname);
//	        return user != null;
//	    }
//	    
	    public void updatePassword(Users user, String newPassword) {
	        user.setPassword(newPassword);
	        userRepository.save(user);
	    }
	    
	    public Optional<Users> findById(Integer id) {
			return userRepository.findById(id);
		}
	    
	    public void deleteById(Integer id) {
			 userRepository.deleteById(id);
		}
}


