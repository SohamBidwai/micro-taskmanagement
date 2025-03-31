package com.taskreports.controller;

import com.taskreports.entity.Task;
import com.taskreports.service.TaskReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/taskreport")
public class TaskReportController {

    @Autowired
    private TaskReportService taskReportService;

    @GetMapping("/allTaskStatus")
    public List<Task> getAllTaskStatus(){
        return taskReportService.getAllTaskStatus();
    }

    @GetMapping("/getUserTaskPerformance/{id}")
    public List<Task> getUserTaskPerformance(@PathVariable int id){
        return taskReportService.getAllTaskAssignToUser(id);
    }

}
