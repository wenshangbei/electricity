package com.wen.electric.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wen.electric.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee getByLastName(String lastName);
	
}
