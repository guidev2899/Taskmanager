package com.example.Taskmanager.TaskManager.TaskException;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(Long id){
        super("Id Task " + id + " Not Found");
    }
}
