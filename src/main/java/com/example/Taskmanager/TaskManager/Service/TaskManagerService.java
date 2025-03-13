package com.example.Taskmanager.TaskManager.Service;

import com.example.Taskmanager.TaskManager.Model.TaskManagerModel;
import com.example.Taskmanager.TaskManager.Repository.TaskManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskManagerService {

    private TaskManagerRepository taskManagerRepository;

    public TaskManagerService(TaskManagerRepository taskManagerRepository) {
        this.taskManagerRepository = taskManagerRepository;
    }

    public TaskManagerModel createTask(TaskManagerModel taskManagerModel){
        taskManagerRepository.save(taskManagerModel);
        return taskManagerModel;
    }

    public List<TaskManagerModel> listTasks(){
        return taskManagerRepository.findAll();
    }



}
