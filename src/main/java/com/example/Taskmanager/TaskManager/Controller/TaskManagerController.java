package com.example.Taskmanager.TaskManager.Controller;


import com.example.Taskmanager.TaskManager.Model.TaskManagerModel;
import com.example.Taskmanager.TaskManager.Service.TaskManagerService;
import com.example.Taskmanager.TaskManager.TaskException.TaskNotFoundException;


import com.example.Taskmanager.TaskManager.TaskManagerDTO.TaskManagerDTOEntry;
import com.example.Taskmanager.TaskManager.TaskManagerDTO.TaskManagerDTOResponse;
import com.example.Taskmanager.TaskManager.Util.TaskMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskManagerController {

    private TaskManagerService taskManagerService;


    public TaskManagerController(TaskManagerService taskManagerService) {
        this.taskManagerService = taskManagerService;
    }

    @PostMapping("/create")
    public ResponseEntity<TaskManagerDTOResponse> createTaskController(@Valid @RequestBody TaskManagerDTOEntry taskManagerDTOEntry) {
        TaskManagerModel taskModel = TaskMapper.toModel(taskManagerDTOEntry);
        taskManagerService.createTask(taskModel);
        TaskManagerDTOResponse taskResponse = TaskMapper.toResponse(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskResponse);
    }

    @GetMapping()
    public ResponseEntity<List<TaskManagerDTOResponse>> listTasks(){
        List<TaskManagerModel> listTasksModel = taskManagerService.listTasks();
        List<TaskManagerDTOResponse> listTasksDTOResponse =  listTasksModel.stream()
                .map(task -> TaskMapper.toResponse(task))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(listTasksDTOResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskManagerDTOResponse> taskManagerDTOResponseEntity(@PathVariable Long id){
        TaskManagerModel taskFound = taskManagerService.getByIdTasks(id)
                .orElseThrow(() -> new TaskNotFoundException(id)
                );
        TaskManagerDTOResponse taskResponse = TaskMapper.toResponse(taskFound);
        return ResponseEntity.status(HttpStatus.OK).body(taskResponse);
    }



}
