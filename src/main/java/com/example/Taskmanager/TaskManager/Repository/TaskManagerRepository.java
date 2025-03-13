package com.example.Taskmanager.TaskManager.Repository;

import com.example.Taskmanager.TaskManager.Model.TaskManagerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskManagerRepository extends JpaRepository<TaskManagerModel, Long> {
}
