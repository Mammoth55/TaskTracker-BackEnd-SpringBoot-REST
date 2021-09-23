package com.capital.tasktracker.dto;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private int id;
    private String title;
    private String text;
    private Timestamp time;
    private int userId;
    private String status;
    private String priority;
}