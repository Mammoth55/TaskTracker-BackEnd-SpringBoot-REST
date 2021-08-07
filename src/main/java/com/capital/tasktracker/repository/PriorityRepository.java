package com.capital.tasktracker.repository;

import com.capital.tasktracker.model.TaskPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PriorityRepository extends JpaRepository<TaskPriority, Integer> {

    @Query("FROM TaskPriority tp where tp.priority = ?1")
    TaskPriority findByName(String name);
}