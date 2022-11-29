package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

	User findByUserIdAndIsActiveTrue(int id);

	void deleteByUserId(int id);

}
