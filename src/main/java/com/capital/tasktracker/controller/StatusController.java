package com.capital.tasktracker.controller;

import com.capital.tasktracker.dto.TaskStatusDtoResponse;
import com.capital.tasktracker.service.StatusService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/statuses")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/")
    public ResponseEntity<TaskStatusDtoResponse> getAllTaskStatuses() {
        return statusService.getAllTaskStatuses();
    }
}