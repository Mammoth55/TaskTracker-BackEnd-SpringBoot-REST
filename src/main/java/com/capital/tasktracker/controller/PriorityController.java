package com.capital.tasktracker.controller;

import com.capital.tasktracker.dto.TaskPriorityDtoResponse;
import com.capital.tasktracker.service.PriorityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/priorities")
public class PriorityController {

    private final PriorityService priorityService;

    public PriorityController(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @GetMapping("/")
    public ResponseEntity<TaskPriorityDtoResponse> getAllTaskPriorities() {
        return priorityService.getAllTaskPriorities();
    }
}