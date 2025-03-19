package com.example.Taskmanager.TaskManager.Util;

import com.example.Taskmanager.TaskManager.Model.TaskManagerModel;
import com.example.Taskmanager.TaskManager.TaskManagerDTO.TaskManagerDTOEntry;
import com.example.Taskmanager.TaskManager.TaskManagerDTO.TaskManagerDTOResponse;

public class TaskMapper {


    public TaskMapper() {
    }

    public static TaskManagerModel toModel(TaskManagerDTOEntry taskManagerDTOEntry){
        return new TaskManagerModel(
                taskManagerDTOEntry.title(),
                taskManagerDTOEntry.description(),
                taskManagerDTOEntry.priority()
        );
    }

    public static TaskManagerDTOResponse toResponse(TaskManagerModel taskManagerModel){
        return new TaskManagerDTOResponse(
                taskManagerModel.getTitle(),
                taskManagerModel.getDescription(),
                taskManagerModel.getStatus(),
                taskManagerModel.getPriority()
        );
    }


}
