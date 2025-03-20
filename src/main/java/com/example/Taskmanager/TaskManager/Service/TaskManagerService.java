package com.example.Taskmanager.TaskManager.Service;

import com.example.Taskmanager.TaskManager.Model.Enum.TaskPriority;
import com.example.Taskmanager.TaskManager.Model.Enum.TaskStatus;
import com.example.Taskmanager.TaskManager.Model.TaskManagerModel;
import com.example.Taskmanager.TaskManager.Repository.TaskManagerRepository;
import com.example.Taskmanager.TaskManager.TaskException.TaskNotFoundException;
import com.example.Taskmanager.TaskManager.TaskManagerDTO.TaskManagerDTOResponse;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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

    public Optional<TaskManagerModel> getByIdTasks(Long id){
        return taskManagerRepository.findById(id);
    }

    public List<TaskManagerModel> getByTaskForPriority(TaskPriority priority){
        return taskManagerRepository.findBypriority(priority);
    }

    public List<TaskManagerModel> getByTaskForStatus(TaskStatus status){
        return taskManagerRepository.findByStatus(status);
    }

}
