package com.taskreports.controller;

import com.taskreports.entity.Task;
import com.taskreports.service.TaskReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/taskreport")
public class TaskReportController {

    @Autowired
    private TaskReportService taskReportService;

    @GetMapping("/allTaskStatus")
    public List<Task> getAllTaskStatus(@RequestBody Task task){

        List<Task> getFillteredData = new ArrayList<>();

        if(!task.getStatus().equals("")){
            String status = task.getStatus();
            getFillteredData = taskReportService.getAllTaskStatusFillteredData(status);
        }else{
            getFillteredData = taskReportService.getAllTaskStatus();
        }
        return getFillteredData;
    }

    @GetMapping("/getUserTaskPerformance/{id}")
    public List<Task> getUserTaskPerformance(@PathVariable int id){
        return taskReportService.getAllTaskAssignToUser(id);
    }
//Neha here
}
