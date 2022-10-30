package com.qeema.service;

import java.util.Optional;

import com.qeema.entity.User;

public interface UserService {

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	public void saveOrUpdate(User user);
}
