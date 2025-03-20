package com.example.Taskmanager.TaskManager.Controller;


import com.example.Taskmanager.TaskManager.Model.Enum.TaskPriority;
import com.example.Taskmanager.TaskManager.Model.Enum.TaskStatus;
import com.example.Taskmanager.TaskManager.Model.TaskManagerModel;
import com.example.Taskmanager.TaskManager.Service.TaskManagerService;
import com.example.Taskmanager.TaskManager.TaskException.ListTaskNotFoundException;
import com.example.Taskmanager.TaskManager.TaskException.NullTaskException;
import com.example.Taskmanager.TaskManager.TaskException.TaskNotFoundException;


import com.example.Taskmanager.TaskManager.TaskManagerDTO.TaskManagerDTOEntry;
import com.example.Taskmanager.TaskManager.TaskManagerDTO.TaskManagerDTOResponse;
import com.example.Taskmanager.TaskManager.Util.TaskMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tasks")
public class TaskManagerController {

    private final TaskManagerService taskManagerService;


    public TaskManagerController(TaskManagerService taskManagerService) {
        this.taskManagerService = taskManagerService;
    }

    @PostMapping("/create")
    public ResponseEntity<TaskManagerDTOResponse> createTask(@Valid @RequestBody TaskManagerDTOEntry taskManagerDTOEntry) {
        TaskManagerModel taskModel = TaskMapper.toModel(taskManagerDTOEntry);
        taskManagerService.createTask(taskModel);
        TaskManagerDTOResponse taskResponse = TaskMapper.toResponse(taskModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(taskResponse);
    }

    @GetMapping()
    public ResponseEntity<List<TaskManagerDTOResponse>> listTasks(){
        List<TaskManagerModel> listTasksModel = taskManagerService.listTasks();
        List<TaskManagerDTOResponse> listTasksDTOResponse =  listTasksModel.stream()
                .map(TaskMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(listTasksDTOResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskManagerDTOResponse> foundTaskForId(@PathVariable Long id){
        TaskManagerModel taskFound = taskManagerService.getByIdTasks(id)
                .orElseThrow(() -> new TaskNotFoundException(id)
                );
        TaskManagerDTOResponse taskResponse = TaskMapper.toResponse(taskFound);
        return ResponseEntity.status(HttpStatus.OK).body(taskResponse);
    }

    @GetMapping("/priority")
    public ResponseEntity<List<TaskManagerDTOResponse>> foundTaskForPriority(@RequestParam(name = "priority") TaskPriority priority){
        List<TaskManagerModel> tasksModels = taskManagerService.getByTaskForPriority(priority);
        if(tasksModels.isEmpty()){
            throw new ListTaskNotFoundException("Nothing tasks found with priority information");
        }
        List<TaskManagerDTOResponse> tasksDTOResponse = tasksModels.stream()
                .map(TaskMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(tasksDTOResponse);

    }

    @GetMapping("/status")
    public ResponseEntity<List<TaskManagerDTOResponse>> foundTaskForStatus(@RequestParam(name = "status")TaskStatus status){
        List<TaskManagerModel> tasksModels = taskManagerService.getByTaskForStatus(status);
        if(tasksModels.isEmpty()){
            throw new ListTaskNotFoundException("Nothing tasks found with status information");
        }
        List<TaskManagerDTOResponse> tasksResponse = tasksModels.stream()
                .map(TaskMapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(tasksResponse);
    }





}
