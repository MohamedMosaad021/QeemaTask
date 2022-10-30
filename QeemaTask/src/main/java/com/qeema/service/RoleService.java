package com.qeema.service;

import java.util.Optional;

import com.qeema.entity.ERole;
import com.qeema.entity.Role;

public interface RoleService {

	Optional<Role> findByName(ERole name);

}
