package com.capital.tasktracker.service;

import com.capital.tasktracker.dto.TaskDTO;
import com.capital.tasktracker.dto.TaskDtoResponse;
import com.capital.tasktracker.model.Task;
import com.capital.tasktracker.repository.PriorityRepository;
import com.capital.tasktracker.repository.StatusRepository;
import com.capital.tasktracker.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final StatusRepository statusRepository;
    private final PriorityRepository priorityRepository;

    public TaskService(TaskRepository taskRepository, StatusRepository statusRepository, PriorityRepository priorityRepository) {
        this.taskRepository = taskRepository;
        this.statusRepository = statusRepository;
        this.priorityRepository = priorityRepository;
    }

    public ResponseEntity<TaskDtoResponse> getAllTasks() {
        TaskDtoResponse taskDtoResponse = new TaskDtoResponse();
        for (Task task : taskRepository.findAll()) {
            taskDtoResponse.getTasks().add(taskToDto(task));
        }
        return new ResponseEntity<>(taskDtoResponse, HttpStatus.OK);
    }

    public ResponseEntity<TaskDtoResponse> getAllTasksActual() {
        TaskDtoResponse taskDtoResponse = new TaskDtoResponse();
        for (Task task : taskRepository.findAllActual()) {
            taskDtoResponse.getTasks().add(taskToDto(task));
        }
        return new ResponseEntity<>(taskDtoResponse, HttpStatus.OK);
    }

    public ResponseEntity<TaskDTO> getTaskById(int taskId) {
        TaskDTO dto = taskToDto(taskRepository.findById(taskId).
                orElseThrow(() -> new EntityNotFoundException("There is no Task with ID = " + taskId + " in Database.")));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    public ResponseEntity<TaskDtoResponse> getTasksByQuery(String query) {
        TaskDtoResponse taskDtoResponse = new TaskDtoResponse();
        for (Task task : taskRepository.findAllByQuery(query)) {
            taskDtoResponse.getTasks().add(taskToDto(task));
        }
        return new ResponseEntity<>(taskDtoResponse, HttpStatus.OK);
    }

    public ResponseEntity<TaskDtoResponse> getTasksByDate(String date) {
        TaskDtoResponse taskDtoResponse = new TaskDtoResponse();
        for (Task task : taskRepository.findAllByDate(date)) {
            taskDtoResponse.getTasks().add(taskToDto(task));
        }
        return new ResponseEntity<>(taskDtoResponse, HttpStatus.OK);
    }

    public ResponseEntity<TaskDTO> createTask(TaskDTO dto) {
        Task task = taskRepository.save(dtoToTask(dto));
        return new ResponseEntity<>(taskToDto(task), HttpStatus.OK);
    }

    public ResponseEntity<TaskDTO> updateTask(TaskDTO dto, int taskId) {
        taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("There is no Task with ID = " + taskId + " in Database."));
        Task task = dtoToTask(dto);
        task.setId(taskId);
        taskRepository.save(task);
        return new ResponseEntity<>(taskToDto(task), HttpStatus.OK);
    }

    public ResponseEntity<TaskDTO> deleteTaskById(int taskId) {
        TaskDTO dto = taskToDto(taskRepository.findById(taskId).
                orElseThrow(() -> new EntityNotFoundException("There is no Task with ID = " + taskId + " in Database.")));
        taskRepository.deleteById(taskId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    public ResponseEntity<TaskDtoResponse> deleteAllTasks() {
        taskRepository.deleteAll();
        return new ResponseEntity<>(new TaskDtoResponse(), HttpStatus.OK);
    }

    public TaskDTO taskToDto(Task task) {
        if (task == null) {
            return null;
        }
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setText(task.getText());
        taskDTO.setTime(task.getTime());
        taskDTO.setUserId(task.getUserId());
        taskDTO.setStatus(task.getStatus().getStatus());
        taskDTO.setPriority(task.getPriority().getPriority());
        return taskDTO;
    }

    public Task dtoToTask(TaskDTO dto) {
        if (dto == null) {
            return null;
        }
        Task task = new Task();
        task.setId(dto.getId());
        task.setTitle(dto.getTitle());
        task.setText(dto.getText());
        task.setTime(dto.getTime());
        task.setUserId(dto.getUserId());
        task.setStatus(statusRepository.findByName(dto.getStatus()));
        task.setPriority(priorityRepository.findByName(dto.getPriority()));
        return task;
    }
}