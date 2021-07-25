package com.capital.tasktracker.controller;

import com.capital.tasktracker.dto.TaskDTO;
import com.capital.tasktracker.dto.TaskDtoResponse;
import com.capital.tasktracker.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiTaskController {

    private final TaskService taskService;

    public ApiTaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public ResponseEntity<TaskDtoResponse> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/actual")
    public ResponseEntity<TaskDtoResponse> getAllTasksActual() {
        return taskService.getAllTasksActual();
    }

    @GetMapping("/tasks/{taskId}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable("taskId") int taskId) {
        return taskService.getTaskById(taskId);
    }

    @GetMapping("/tasks/byQuery")
    public ResponseEntity<TaskDtoResponse> getTasksByQuery(@RequestParam(name = "query", required = false, value = "query") String query) {
        return taskService.getTasksByQuery(query);
    }

    @GetMapping("/tasks/byDate")
    public ResponseEntity<TaskDtoResponse> getTasksByDate(@RequestParam(name = "date", required = false, value = "date") String date) {
        return taskService.getTasksByDate(date);
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskDTO> createTask(@ModelAttribute("task") TaskDTO task) {
        return taskService.createTask(task);
    }

    @PatchMapping("/tasks/{taskId}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable("taskId") int taskId, @ModelAttribute("task") TaskDTO task) {
        return taskService.updateTask(task, taskId);
    }

    @DeleteMapping("/tasks/{taskId}")
    public ResponseEntity<TaskDTO> deleteTask(@PathVariable("taskId") int taskId) {
        return taskService.deleteTaskById(taskId);
    }

    @DeleteMapping("/tasks")
    public ResponseEntity<TaskDtoResponse> deleteAllTasks() {
        return taskService.deleteAllTasks();
    }
}