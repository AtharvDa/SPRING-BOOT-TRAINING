package com.effigo.learningportal.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.effigo.learningportal.entity.Course;
import com.effigo.learningportal.entity.User;
import com.effigo.learningportal.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User newUser = userService.createUser(user);
		return ResponseEntity.ok(newUser);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
		return userService.getUserById(userId).map(user -> ResponseEntity.ok(mapUserToDTO(user)))
				.orElse(ResponseEntity.notFound().build());
	}

	private UserDTO mapUserToDTO(User user) {
		return new UserDTO(user.getUserId(), user.getUsername(), user.getPassword(), user.getRole(),
				user.getCreatedOn(), user.getUpdatedOn());
	}

	@GetMapping("/{userId}/favorites")
	public ResponseEntity<Set<Course>> getUserFavorites(@PathVariable Long userId) {
		Set<Course> favorites = userService.getUserFavorites(userId);
		return ResponseEntity.ok(favorites);
	}

}
