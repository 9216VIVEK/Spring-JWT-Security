package com.SpringSecurity.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSecurity.model.UserVO;

public interface UserRepository extends JpaRepository<UserVO, Long> {
	
	UserVO findByUsername(String username);
}
