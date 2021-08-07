package com.capital.tasktracker.repository;

import com.capital.tasktracker.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StatusRepository extends JpaRepository<TaskStatus, Integer> {

    @Query("FROM TaskStatus ts where ts.status = ?1")
    TaskStatus findByName(String name);
}