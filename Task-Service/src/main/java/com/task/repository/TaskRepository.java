package com.task.repository;

import com.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    Task findByTaskId(int taskId);

    List<Task> findByAssignToId(int assignToId);

}
