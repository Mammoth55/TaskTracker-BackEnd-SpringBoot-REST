package com.capital.tasktracker.dto;

import com.capital.tasktracker.model.Task;
import org.mapstruct.Mapper;

@Mapper
public interface TaskDtoMapper {

    TaskDTO taskToDto(Task task);
    Task dtoToTask(TaskDTO dto);
}
