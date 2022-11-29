package com.cts.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.User;
import com.cts.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	public User getUserById(int id) {
		return userRepo.findByUserIdAndIsActiveTrue(id);
	}

	public String saveUser(User user) {
		try {
			if (!Objects.isNull(user)) {
				userRepo.save(user);
				return "User Saved Sucessfully!!";
			}
		} catch (Exception e) {
			return "Unable to Save User";
		}
		return "Unable to Save User";
	}

	public String updateUserById(User user) {
		if (!Objects.isNull(userRepo.findByUserIdAndIsActiveTrue(user.getUserId()))) {
			userRepo.save(user);
			return "User Upadted Sucessfully!!";
		}
		return "Unable to Update User";
	}

	@Transactional
	public String deleteUserById(int id) {
		userRepo.deleteByUserId(id);
		return "User Deleted Successfully";
	}

}
