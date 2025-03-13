package com.example.Taskmanager.TaskManager.TaskManagerDTO;

import com.example.Taskmanager.TaskManager.Model.Enum.TaskPriority;


public record TaskManagerDTO(String title,
                             String description,
                             TaskPriority priority) {
}
