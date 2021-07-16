package com.capital.tasktracker.dto;

import java.util.ArrayList;
import java.util.List;

public class TaskDtoResponse {

    private List<TaskDTO> tasks;

    public TaskDtoResponse() {
        this.tasks = new ArrayList<>();
    }

    public TaskDtoResponse(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }
}