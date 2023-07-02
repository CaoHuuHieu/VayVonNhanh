package com.vayvonnhanh.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vayvonnhanh.config.UserDetail;
import com.vayvonnhanh.entity.User;
import com.vayvonnhanh.repository.UserRepository;
@Service
public class UserService implements UserDetailsService{
	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Override
	public UserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
		  Optional<User> user = userRepository.findByUsername(username);
		  if(user.isPresent()) {
			  return new UserDetail(user.get());
		  }else throw new UsernameNotFoundException("Can not find account!");
	}
	
	 public String addUser() {
		 	User user = new User();
		 	user.setUsername("minhnhat");
		 	user.setPassword(passwordEncoder.encode("vayvon365"));
		 	user.setRole("ADMIN");
		 	userRepository.save(user);
	        return "Thêm user thành công!";
	    }
	

}
