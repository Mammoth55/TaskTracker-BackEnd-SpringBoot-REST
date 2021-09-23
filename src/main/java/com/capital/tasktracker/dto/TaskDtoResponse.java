package com.capital.tasktracker.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskDtoResponse {

    private List<TaskDTO> tasks;

    public TaskDtoResponse() {
        this.tasks = new ArrayList<>();
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }
}