package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.model.User;
import com.cts.service.UserService;

@RestController
@RequestMapping("/userManagement")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/getAllUser")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}

	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@PostMapping("/saveUser")
	public String saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@PutMapping("/updateUser")
	public String updateUser(@RequestBody User user) {
		return userService.updateUserById(user);
	}

	@DeleteMapping("/deleteUserById/{id}")
	public String deleteUserById(@PathVariable("id") int id) {
		return userService.deleteUserById(id);
	}
}
