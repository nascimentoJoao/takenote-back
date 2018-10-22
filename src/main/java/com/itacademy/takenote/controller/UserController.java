package com.itacademy.takenote.controller;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itacademy.takenote.model.User;
import com.itacademy.takenote.repository.UserRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/user")
	public User createUser(@Valid @RequestBody User user) {
		//System.out.println(note.toString());
		return userRepository.save(user);
	}
	
	@GetMapping("/user")
	public User searchUser(@Valid String encrypt) {
		return null;
	}
	
	@GetMapping("/users")
	public List<String> getAllUsernames(){
		LinkedList<String> usernames = new LinkedList<>();
		for(User us : this.userRepository.findAll()) {
			usernames.add(us.getUsername());
		}
		return usernames;
	}
	
}
