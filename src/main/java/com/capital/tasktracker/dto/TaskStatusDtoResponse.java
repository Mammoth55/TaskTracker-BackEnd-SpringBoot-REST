package com.capital.tasktracker.dto;

import com.capital.tasktracker.model.TaskStatus;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskStatusDtoResponse {

    private List<TaskStatus> statuses;

    public TaskStatusDtoResponse() {
        this.statuses = new ArrayList<>();
    }
}