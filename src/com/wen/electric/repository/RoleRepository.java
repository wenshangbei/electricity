package com.wen.electric.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wen.electric.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	
}
