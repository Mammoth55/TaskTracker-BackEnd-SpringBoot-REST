package com.capital.tasktracker.service;

import com.capital.tasktracker.dto.TaskStatusDtoResponse;
import com.capital.tasktracker.repository.StatusRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public ResponseEntity<TaskStatusDtoResponse> getAllTaskStatuses() {
        return new ResponseEntity<>(new TaskStatusDtoResponse(statusRepository.findAll()), HttpStatus.OK);
    }
}