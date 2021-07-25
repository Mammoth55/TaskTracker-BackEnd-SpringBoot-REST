package com.capital.tasktracker.service;

import com.capital.tasktracker.dto.TaskPriorityDtoResponse;
import com.capital.tasktracker.repository.PriorityRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PriorityService {

    private final PriorityRepository priorityRepository;

    public PriorityService(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    public ResponseEntity<TaskPriorityDtoResponse> getAllTaskPriorities() {
        return new ResponseEntity<>(new TaskPriorityDtoResponse(priorityRepository.findAll()), HttpStatus.OK);
    }
}