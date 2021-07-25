package com.capital.tasktracker.repository;

import com.capital.tasktracker.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<TaskStatus, Integer> {

}