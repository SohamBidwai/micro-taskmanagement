package com.taskreports.serviceimpl;

import com.taskreports.entity.Task;
import com.taskreports.service.TaskReportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskReportServiceImplementation implements TaskReportService {
    @Override
    public List<Task> getAllTaskStatus() {
        return List.of();
    }

    @Override
    public List<Task> getAllTaskAssignToUser(int assignToId) {
        return List.of();
    }
}
