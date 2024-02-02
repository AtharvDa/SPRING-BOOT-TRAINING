package com.effigo.todo.taskManager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.effigo.todo.taskManager.entity.Task;
import com.effigo.todo.taskManager.repository.TaskRepository;

import jakarta.transaction.Transactional;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public Task createTask(Task task) {
		return taskRepository.save(task);
	}

	public List<Task> getStudentTasks(Long studentId) {
		return taskRepository.findAllById(studentId);
	}

	@Transactional
	public void deleteStudentsTask(Long studentId) {
		taskRepository.deleteAllTasksByStudentId(studentId);

	}

//	public void deleteParticularTask(Long studentId, Long taskId) {
//		Optional<Task> taskOptional = taskRepository.findByStudentIdAndTaskId(studentId, taskId);
//		taskOptional.ifPresent(task -> taskRepository.delete(task));
//	}

}
