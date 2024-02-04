package com.effigo.learningportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.effigo.learningportal.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
