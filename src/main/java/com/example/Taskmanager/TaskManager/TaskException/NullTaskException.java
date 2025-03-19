package com.example.Taskmanager.TaskManager.TaskException;

public class NullTaskException extends RuntimeException {
    public NullTaskException(){
        super("No field can be null");
    }
}
