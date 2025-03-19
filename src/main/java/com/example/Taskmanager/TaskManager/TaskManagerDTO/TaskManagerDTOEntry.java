package com.example.Taskmanager.TaskManager.TaskManagerDTO;

import com.example.Taskmanager.TaskManager.Model.Enum.TaskPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record TaskManagerDTOEntry(
        @NotBlank(message = "The Title can be not empty")
        @NotNull(message = "The Title can be null")
        String title,

        @NotBlank(message = "The description can be not empty")
        @NotNull(message = "The description can be not null")
        String description,

        @NotNull(message = "The priority can be not null")
        TaskPriority priority) {


}
