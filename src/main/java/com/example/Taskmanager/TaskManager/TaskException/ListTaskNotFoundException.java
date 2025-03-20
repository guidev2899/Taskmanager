package com.example.Taskmanager.TaskManager.TaskException;

public class ListTaskNotFoundException extends RuntimeException {
    public ListTaskNotFoundException(){
        super("Nothing tasks found with priority information");
    }
}
