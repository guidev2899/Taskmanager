package com.example.Taskmanager.TaskManager.Repository;

import com.example.Taskmanager.TaskManager.Model.Enum.TaskPriority;
import com.example.Taskmanager.TaskManager.Model.Enum.TaskStatus;
import com.example.Taskmanager.TaskManager.Model.TaskManagerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskManagerRepository extends JpaRepository<TaskManagerModel, Long> {
    List<TaskManagerModel> findByStatus(TaskStatus status);
    List<TaskManagerModel> findBypriority(TaskPriority priority);

}
