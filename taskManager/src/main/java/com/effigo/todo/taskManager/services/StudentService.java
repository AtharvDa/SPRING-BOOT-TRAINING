package com.effigo.todo.taskManager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effigo.todo.taskManager.entity.Student;
import com.effigo.todo.taskManager.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	public Optional<Student> findStudentById(Long studentId) {
		return studentRepository.findById(studentId);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public void deleteStudentsTask(Long studentId) {
		studentRepository.deleteById(studentId);
	}
}
