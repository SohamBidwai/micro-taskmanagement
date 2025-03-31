package com.taskreports.repository;

import com.taskreports.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskReportRepository extends JpaRepository<Task, Integer> {
}
