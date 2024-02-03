package com.effigo.learningportal.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effigo.learningportal.entity.Course;
import com.effigo.learningportal.entity.User;
import com.effigo.learningportal.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public Optional<User> getUserById(Long userId) {
		return userRepository.findById(userId);
	}

	public Set<Course> getUserFavorites(Long userId) {
		Optional<User> userOptional = userRepository.findById(userId);
		return userOptional.map(User::getFavorites).orElse(Set.of());
	}

}
