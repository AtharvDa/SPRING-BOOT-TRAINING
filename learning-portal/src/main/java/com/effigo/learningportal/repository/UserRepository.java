package com.effigo.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.effigo.learningportal.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}