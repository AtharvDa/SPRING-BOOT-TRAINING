package com.effigo.todo.taskManager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.effigo.todo.taskManager.entity.Student;
import com.effigo.todo.taskManager.entity.Task;
import com.effigo.todo.taskManager.services.StudentService;
import com.effigo.todo.taskManager.services.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;
	@Autowired
	private StudentService studentService;

	@GetMapping("/{studentId}")
	public List<Task> getStudentTasks(@PathVariable Long studentId) {

		List<Task> tasks = taskService.getStudentTasks(studentId);
		return tasks;
	}

	@PostMapping("/{studentId}")
	public ResponseEntity<Task> createTask(@PathVariable Long studentId, @RequestBody Task task) {

		Optional<Student> studentOptional = studentService.findStudentById(studentId);

		if (studentOptional.isPresent()) {
			Student student = studentOptional.get();
			task.setStudent(student);
			Task newTask = taskService.createTask(task);
			System.out.println(newTask);
			return new ResponseEntity<>(newTask, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("deleteAll/{studentId}")
	public ResponseEntity<String> deleteStudentsTask(@PathVariable Long studentId) {
		Optional<Student> studentOptional = studentService.findStudentById(studentId);

		if (studentOptional.isPresent()) {
			taskService.deleteStudentsTask(studentId);
			return new ResponseEntity<>("All tasks deleted for student with ID: " + studentId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
		}
//		return new ResponseEntity<String>("All Task Associated with Student Deleted Successfully", HttpStatus.OK);
	}

//	@DeleteMapping("delete/{studentId}/{taskId}")
//	public ResponseEntity<String> deleteTaskById(@PathVariable Long studentId, @PathVariable Long taskId) {
//
//		Optional<Student> studentOptional = studentService.findStudentById(studentId);
//
//		if (studentOptional.isPresent()) {
//			taskService.deleteParticularTask(studentId, taskId);
//			return new ResponseEntity<>("Task deleted successfully for student with ID: " + studentId, HttpStatus.OK);
//		} else {
//			return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
//		}
//	}

}
