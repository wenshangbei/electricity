package com.wen.electric.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wen.electric.entity.Department;
import com.wen.electric.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Transactional(readOnly=true)
	public List<Department> getAll(){
		return departmentRepository.getAll();
	}
}
