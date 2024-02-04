package com.effigo.learningportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.effigo.learningportal.entity.Course;

@RestController
@RequestMapping("/courses")
public class CourseController {

	private final CourseService courseService;

	@Autowired
	public CourseController(CourseService courseService) {
		this.courseService = courseService;
	}

	@PostMapping
	public ResponseEntity<Course> createCourse(@RequestBody CourseDTO courseDTO) {
		Course course = courseService.createCourse(courseDTO.getTitle(), courseDTO.getCategory(),
				courseDTO.getAuthor());
		return ResponseEntity.ok(course);
	}

	@GetMapping("/{courseId}")
	public ResponseEntity<Course> getCourseById(@PathVariable Long courseId) {
		Course course = courseService.getCourseById(courseId);
		return ResponseEntity.of(Optional.ofNullable(course));
	}

}
