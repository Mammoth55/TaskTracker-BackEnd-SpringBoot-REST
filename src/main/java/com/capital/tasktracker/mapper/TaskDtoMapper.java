package com.capital.tasktracker.mapper;

import com.capital.tasktracker.dto.TaskDTO;
import com.capital.tasktracker.model.Task;
import com.capital.tasktracker.model.TaskPriority;
import com.capital.tasktracker.model.TaskStatus;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface TaskDtoMapper {

    TaskDtoMapper TASK_MAPPER = Mappers.getMapper(TaskDtoMapper.class);

    TaskDTO fromTask(Task task);

    default String fromStatus(TaskStatus status) {
        return status.getStatus();
    }

    default String fromPriority(TaskPriority priority) {
        return priority.getPriority();
    }

    @InheritInverseConfiguration
    Task toTask(TaskDTO dto);

    default TaskStatus toStatus(String status) {
        return new TaskStatus(status);
    }

    default TaskPriority toPriority(String priority) {
        return new TaskPriority(priority);
    }

}
