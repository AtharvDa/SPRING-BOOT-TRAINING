package com.effigo.demopostgres.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployeeById(Long id) {
		return employeeRepository.findById(id);
	}

	public Employee createEmployee(Employee employee) {
//		employee.setCreatedOn(LocalDateTime.now());
//		employee.setUpdatedOn(LocalDateTime.now());
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Long id, Employee updatedEmployee) {

		if (employeeRepository.existsById(id)) {
			updatedEmployee.setId(id);
//			updatedEmployee.setUpdatedOn(LocalDateTime.now());
			return employeeRepository.save(updatedEmployee);
		}

		return null;
	}

	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

}
