package com.task.controller;

import com.task.entity.Task;
import com.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/addTask")
    public String saveTaskDetails(@RequestBody Task task){

        Date todayDate = new Date();
        task.setCreatedOn(todayDate);

        taskService.add(task);

        return "success";
    }

    @GetMapping("/getSpecificTask/{id}")
    public Task getSpecificTask(@PathVariable int id){
        return taskService.getTaskById(id);
    }

    //User Update Task Status
    @PutMapping("/updateTaskStatus/{id}")
    public Task updateTaskStatus(@PathVariable int id, @RequestBody Task task){
        return taskService.userTaskUpdate(id, task);
    }

    //Admin and Team Leader Update Task Details
    @PutMapping("/updateTask/{id}")
    public Task updateTaskDetails(@PathVariable int id, @RequestBody Task task){
        return taskService.updateTaskDetails(id, task);
    }

    @GetMapping("/userAllTask/{assignToId}")
    public List<Task> getAllTaskAgainstUser(@PathVariable int assignToId){
        return taskService.getAllTaskAgainstUser(assignToId);
    }

    @GetMapping
    public List<Task> getAllTask(){
        return taskService.getAllTask();
    }

}
