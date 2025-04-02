package com.taskreports.repository;

import com.taskreports.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskReportRepository extends JpaRepository<Task, Integer> {

    List<Task> findByStatus(String status);

    List<Task> findByAssignToId(int assignToId);

}
