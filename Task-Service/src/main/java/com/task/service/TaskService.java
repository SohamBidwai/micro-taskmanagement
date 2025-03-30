package com.task.service;

import com.task.entity.Task;

import java.util.List;

public interface TaskService {

    //save
    Task add(Task task);

    //get by task id
    Task getTaskById(int taskId);

    //get all task admin or Team Leader
    List<Task> getAllTask();

    //update task status by user
    Task userTaskUpdate(int taskId, Task task);

    //get all task of specific user
    List<Task> getAllTaskAgainstUser(int assignToId);

    //update task details only by admin or Team Leader
    Task updateTaskDetails(int taskId, Task task);



}
