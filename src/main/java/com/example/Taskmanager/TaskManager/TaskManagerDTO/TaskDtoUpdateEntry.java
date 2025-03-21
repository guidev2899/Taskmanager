package com.example.Taskmanager.TaskManager.TaskManagerDTO;

import com.example.Taskmanager.TaskManager.Model.Enum.TaskPriority;
import com.example.Taskmanager.TaskManager.Model.Enum.TaskStatus;

public record TaskDtoUpdateEntry(
        String title,
        String description,
        TaskPriority priority,
        TaskStatus status
) {
}
