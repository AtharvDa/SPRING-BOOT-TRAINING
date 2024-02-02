package com.effigo.todo.taskManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.effigo.todo.taskManager.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
