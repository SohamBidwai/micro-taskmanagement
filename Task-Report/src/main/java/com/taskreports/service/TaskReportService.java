package com.taskreports.service;

import com.taskreports.entity.Task;

import java.util.List;

public interface TaskReportService {

    //For Admin and Team Leader Use Only
    List<Task> getAllTaskStatus();

    List<Task> getAllTaskStatusFillteredData(String status);

    //Get All Task those assign to User(User Performance Report)
    List<Task> getAllTaskAssignToUser(int assignToId);

}
