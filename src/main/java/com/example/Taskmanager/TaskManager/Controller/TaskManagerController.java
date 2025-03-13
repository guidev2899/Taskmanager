package com.example.Taskmanager.TaskManager.Controller;


import com.example.Taskmanager.TaskManager.Model.TaskManagerModel;
import com.example.Taskmanager.TaskManager.Service.TaskManagerService;
import com.example.Taskmanager.TaskManager.TaskManagerDTO.TaskManagerDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public ResponseEntity<List<TaskManagerModel>> listTasks(){
        return ResponseEntity.status(HttpStatus.FOUND).body(taskManagerService.listTasks());
    }

}
