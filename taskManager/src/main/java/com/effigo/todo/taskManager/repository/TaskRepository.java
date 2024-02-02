package com.effigo.todo.taskManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.effigo.todo.taskManager.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findAllById(Long studentId);

	void deleteAllTasksByStudentId(Long studentId);

//	Optional<Task> findByStudentIdAndTaskId(Long studentId, Long taskId);

}
