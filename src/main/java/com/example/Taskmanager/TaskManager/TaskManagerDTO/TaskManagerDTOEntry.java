package com.example.Taskmanager.TaskManager.TaskManagerDTO;

import com.example.Taskmanager.TaskManager.Model.Enum.TaskPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record TaskManagerDTOEntry(
        @NotBlank(message = "O Título não pode ser vazio")
        @NotNull(message = "O Título não pode ser Nulo")
        String title,

        @NotBlank(message = "A descrição não pode ser vazio")
        @NotNull(message = "O Título não pode ser Nulo")
        String description,

        @NotNull(message = "A prioridade não pode ser vazio")
        TaskPriority priority) {


}
