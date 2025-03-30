package com.userservice.serviceimpl;

import com.userservice.entity.UserEntity;
import com.userservice.entity.taskClient.Task;
import com.userservice.services.taskClient.TaskClient;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import com.userservice.repository.UserRepository;
import com.userservice.services.UserServce;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImplementation implements UserServce {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskClient taskClient;

    @Override
    public UserEntity add(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity get(int id) {
        UserEntity getUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
        return getUser;
    }

    @Override
    public Task updateTaskStatus(int taskId, Task task) {
        return taskClient.updateTaskStatus(taskId, task);
    }

    @Override
    public Task addNewTask(Task task) {
        return taskClient.saveTaskDetails(task);
    }
}
