package com.example.Taskmanager.TaskManager.TaskException;

public class StatusNotValidException extends RuntimeException {
    public StatusNotValidException(String message) {
        super(message);
    }
}
