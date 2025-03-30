package com.userservice.services;

import com.userservice.entity.UserEntity;
import com.userservice.entity.taskClient.Task;

public interface UserServce {

    UserEntity add(UserEntity user);

    UserEntity get(int id);

    Task updateTaskStatus(int taskId, Task task);

    Task addNewTask(Task task);

}
