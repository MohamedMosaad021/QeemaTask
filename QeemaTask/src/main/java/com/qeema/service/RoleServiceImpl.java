package com.qeema.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qeema.entity.ERole;
import com.qeema.entity.Role;
import com.qeema.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Optional<Role> findByName(ERole name) {
		return roleRepository.findByName(name);
	}

}
