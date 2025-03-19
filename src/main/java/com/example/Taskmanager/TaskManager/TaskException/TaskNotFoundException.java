package com.example.Taskmanager.TaskManager.TaskException;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(Long id){
        super("Tarefa com ID: " + id + " Não encontrada");
    }
}
