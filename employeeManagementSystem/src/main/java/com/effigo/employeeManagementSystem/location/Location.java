package com.effigo.employeeManagementSystem.location;

import java.util.List;

import com.effigo.employeeManagementSystem.department.Department;
import com.effigo.employeeManagementSystem.employee.Employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String city;
	
	private String Country;
	
	@OneToMany(mappedBy = "location")
	List<Employee> employees;
	
	@OneToMany(mappedBy = "location")
	private List<Department> departments;

	public Location(Long id, String city, String country, List<Employee> employees, List<Department> departments) {
		super();
		this.id = id;
		this.city = city;
		Country = country;
		this.employees = employees;
		this.departments = departments;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
	
}
