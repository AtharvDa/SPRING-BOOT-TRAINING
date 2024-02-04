package com.effigo.learningportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effigo.learningportal.entity.Course;
import com.effigo.learningportal.entity.User;
import com.effigo.learningportal.repository.CourseRepository;

@Service
public class CourseService {

	private final CourseRepository courseRepository;

	@Autowired
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}

	public Course createCourse(String title, String category, User author) {
		Course course = new Course(title, category, author);
		return courseRepository.save(course);
	}

	public Course getCourseById(Long courseId) {
		return courseRepository.findById(courseId).orElse(null);
	}

}
