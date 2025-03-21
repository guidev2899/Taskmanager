package com.example.Taskmanager.TaskManager.Util;


import com.example.Taskmanager.TaskManager.Model.Enum.TaskStatus;
import com.example.Taskmanager.TaskManager.Model.TaskManagerModel;
import com.example.Taskmanager.TaskManager.TaskException.StatusNotValidException;
import com.example.Taskmanager.TaskManager.TaskManagerDTO.TaskDtoUpdateEntry;


public class UpdateTask {

    public static TaskManagerModel updateTask(TaskDtoUpdateEntry taskDtoUpdateEntry, TaskManagerModel taskManagerModel){
        taskManagerModel.setTitle(taskDtoUpdateEntry.title());
        taskManagerModel.setDescription(taskDtoUpdateEntry.description());
        if(taskManagerModel.getStatus() == TaskStatus.PENDING && taskDtoUpdateEntry.status() == TaskStatus.COMPLETED){
            throw new StatusNotValidException("To change the status from Pending to Completed, you must first" +
                    " change the status to In Progress");
        }
        taskManagerModel.setStatus(taskDtoUpdateEntry.status());
        taskManagerModel.setPriority(taskDtoUpdateEntry.priority());
        return taskManagerModel;
    }

}
