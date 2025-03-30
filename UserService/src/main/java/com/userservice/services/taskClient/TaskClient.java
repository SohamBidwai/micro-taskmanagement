package com.userservice.services.taskClient;

import com.userservice.config.forFeignClient.FeignClientConfig;
import com.userservice.entity.taskClient.Task;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "Task-Service", url = "http://localhost:9092", configuration = FeignClientConfig.class)
public interface TaskClient {


    @PutMapping("/task/updateTaskStatus/{taskId}")
    Task updateTaskStatus(@PathVariable int taskId, @RequestBody Task task);

    @PostMapping("/task/addTask")
    Task saveTaskDetails(@RequestBody Task task);

}