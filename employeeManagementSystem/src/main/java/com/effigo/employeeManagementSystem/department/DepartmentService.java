package com.effigo.employeeManagementSystem.department;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

	private DepartmentRepository departmentRepository;
	
	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
	
	public Department createDepartment(Department department) {
		return departmentRepository.save(department);
	}
}
