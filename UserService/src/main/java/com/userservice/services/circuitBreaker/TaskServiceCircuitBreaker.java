package com.userservice.services.circuitBreaker;

import com.userservice.entity.taskClient.Task;
import com.userservice.services.taskClient.TaskClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class TaskServiceCircuitBreaker {

    @Autowired
    private TaskClient taskClient;

    @CircuitBreaker(name = "userService", fallbackMethod = "fallbackUpdateTaskStatus")
    public Task updateTaskStatus(int taskId, Task task){
        return taskClient.updateTaskStatus(taskId, task);
    }

    public Task fallbackUpdateTaskStatus(int taskId, Task task, Exception e) {
        System.out.println("Fallback method triggered: " + e.getMessage());

        // Returning a default response in case of failure
        Task fallbackTask = new Task();
        fallbackTask.setTaskId(taskId);
        fallbackTask.setStatus("FAILED_TO_UPDATE");
        return fallbackTask;
    }

}
