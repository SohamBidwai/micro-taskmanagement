package com.taskreports.serviceimpl;

import com.taskreports.entity.Task;
import com.taskreports.repository.TaskReportRepository;
import com.taskreports.service.TaskReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskReportServiceImplementation implements TaskReportService {

    @Autowired
    private TaskReportRepository taskReportRepository;

    @Override
    public List<Task> getAllTaskStatus() {
        return taskReportRepository.findAll();
    }

    @Override
    public List<Task> getAllTaskStatusFillteredData(String status) {
        return taskReportRepository.findByStatus(status);
    }

    @Override
    public List<Task> getAllTaskAssignToUser(int assignToId) {
        return taskReportRepository.findByAssignToId(assignToId);
    }
}
