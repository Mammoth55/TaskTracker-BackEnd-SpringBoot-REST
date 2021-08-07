package com.capital.tasktracker.dto;

import com.capital.tasktracker.model.Task;

public interface TaskDtoMapper {

    TaskDTO taskToDto(Task task);

    Task dtoToTask(TaskDTO dto);
}
