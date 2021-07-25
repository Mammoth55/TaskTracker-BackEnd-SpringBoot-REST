package com.capital.tasktracker.repository;

import com.capital.tasktracker.model.TaskPriority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityRepository extends JpaRepository<TaskPriority, Integer> {

}