package com.capital.tasktracker.dto;

import com.capital.tasktracker.model.TaskPriority;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskPriorityDtoResponse {

    private List<TaskPriority> priorities;

    public TaskPriorityDtoResponse() {
        this.priorities = new ArrayList<>();
    }
}