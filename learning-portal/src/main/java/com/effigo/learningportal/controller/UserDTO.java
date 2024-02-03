package com.effigo.learningportal.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserDTO {

	private Long userId;
	private String username;
	private String password;
	private String role;
	private String createdDate;
	private String updatedDate;

	public UserDTO(Long userId, String username, String password, String role, String createdDate, String updatedDate) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public UserDTO() {

	}

	public UserDTO(Long userId, String username, String password, String role, LocalDateTime createdDate,
			LocalDateTime updatedDate) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.role = role;
		this.createdDate = createdDate != null ? createdDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm"))
				: null;
		this.updatedDate = updatedDate != null ? updatedDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm"))
				: null;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

}
