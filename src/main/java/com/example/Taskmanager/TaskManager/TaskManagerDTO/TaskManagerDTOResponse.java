package com.example.Taskmanager.TaskManager.TaskManagerDTO;

import com.example.Taskmanager.TaskManager.Model.Enum.TaskPriority;
import com.example.Taskmanager.TaskManager.Model.Enum.TaskStatus;

public record TaskManagerDTOResponse(String title,
                                     String description,
                                     TaskStatus status,
                                     TaskPriority priority
                                     ) {
}
