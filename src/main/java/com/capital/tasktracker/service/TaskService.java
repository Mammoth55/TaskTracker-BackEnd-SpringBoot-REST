package com.capital.tasktracker.service;

import com.capital.tasktracker.dto.TaskDTO;
import com.capital.tasktracker.dto.TaskDtoMapper;
import com.capital.tasktracker.dto.TaskDtoResponse;
import com.capital.tasktracker.model.Task;
import com.capital.tasktracker.repository.TaskRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;

@Service
public class TaskService {

//    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final TaskDtoMapper MAPPER = Mappers.getMapper(TaskDtoMapper.class);

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public ResponseEntity<TaskDtoResponse> getAllTasks() {
        TaskDtoResponse taskDtoResponse = new TaskDtoResponse();
        for (Task task : taskRepository.findAll()) {
            taskDtoResponse.getTasks().add(MAPPER.taskToDto(task));
        }
        return new ResponseEntity(taskDtoResponse, HttpStatus.OK);
    }

    public ResponseEntity<TaskDtoResponse> getAllTasksActualAndPriority() {
        TaskDtoResponse taskDtoResponse = new TaskDtoResponse();
        for (Task task : taskRepository.findAllActualAndPriority()) {
            taskDtoResponse.getTasks().add(MAPPER.taskToDto(task));
        }
        return new ResponseEntity(taskDtoResponse, HttpStatus.OK);
    }

    public ResponseEntity<TaskDTO> getTaskById(int taskId) {
        TaskDTO dto = MAPPER.taskToDto(taskRepository.findById(taskId).
                orElseThrow(() -> new EntityNotFoundException("There is no Task with ID = " + taskId + " in Database.")));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    public ResponseEntity<TaskDtoResponse> getTasksByQuery(String query) {
        TaskDtoResponse taskDtoResponse = new TaskDtoResponse();
        for (Task task : taskRepository.findAllByQuery(query)) {
            taskDtoResponse.getTasks().add(MAPPER.taskToDto(task));
        }
        return new ResponseEntity(taskDtoResponse, HttpStatus.OK);
    }

    public ResponseEntity<TaskDtoResponse> getTasksByDate(String date) {
        TaskDtoResponse taskDtoResponse = new TaskDtoResponse();
        for (Task task : taskRepository.findAllByDate(date)) {
            taskDtoResponse.getTasks().add(MAPPER.taskToDto(task));
        }
        return new ResponseEntity(taskDtoResponse, HttpStatus.OK);
    }

    public ResponseEntity<TaskDTO> createTask(TaskDTO dto) {
        Task task = taskRepository.save(MAPPER.dtoToTask(dto));
        return new ResponseEntity(MAPPER.taskToDto(task), HttpStatus.OK);
    }

    public ResponseEntity<TaskDTO> updateTask(TaskDTO dto, int taskId) {
        taskRepository.findById(taskId)
                .orElseThrow(() -> new EntityNotFoundException("There is no Task with ID = " + taskId + " in Database."));
        Task task = MAPPER.dtoToTask(dto);
        task.setId(taskId);
        taskRepository.save(task);
        return new ResponseEntity(MAPPER.taskToDto(task), HttpStatus.OK);
    }

    public ResponseEntity<TaskDTO> deleteTaskById(int taskId) {
        TaskDTO dto = MAPPER.taskToDto(taskRepository.findById(taskId).
                orElseThrow(() -> new EntityNotFoundException("There is no Task with ID = " + taskId + " in Database.")));
        taskRepository.deleteById(taskId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    public ResponseEntity<TaskDtoResponse> deleteAllTasks() {
        taskRepository.deleteAll();
        return new ResponseEntity<>(new TaskDtoResponse(), HttpStatus.OK);
    }
}