package com.example.Taskmanager.TaskManager.Controller;


import com.example.Taskmanager.TaskManager.Model.TaskManagerModel;
import com.example.Taskmanager.TaskManager.Service.TaskManagerService;
import com.example.Taskmanager.TaskManager.TaskManagerDTO.TaskManagerDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskManagerController {

    private TaskManagerService taskManagerService;

    public TaskManagerController(TaskManagerService taskManagerService) {
        this.taskManagerService = taskManagerService;
    }

    @PostMapping("/create")
    public ResponseEntity<TaskManagerDTO> createTaskController(@RequestBody TaskManagerDTO taskManagerDTO){
        TaskManagerModel taskModel = new TaskManagerModel(
                taskManagerDTO.title(),
                taskManagerDTO.description(),
                taskManagerDTO.priority()
        );
        taskManagerService.createTask(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskManagerDTO);
    }

}
