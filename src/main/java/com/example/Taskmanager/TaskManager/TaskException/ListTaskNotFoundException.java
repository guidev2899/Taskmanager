package com.example.Taskmanager.TaskManager.TaskException;

public class ListTaskNotFoundException extends RuntimeException {
    public ListTaskNotFoundException(String message){
        super(message);
    }
}
