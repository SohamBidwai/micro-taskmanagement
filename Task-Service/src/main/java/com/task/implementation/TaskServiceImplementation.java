package com.task.implementation;

import com.task.entity.Task;
import com.task.notification.TaskNotificationProducer;
import com.task.repository.TaskRepository;
import com.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImplementation implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskNotificationProducer taskNotificationProducer;

    @Override
    public void add(Task task) {
        taskRepository.save(task);
        String message = "Task is created and assign to "+task.getAssignToId();
        taskNotificationProducer.sendNotification(message);
    }

    @Override
    public Task getTaskById(int taskId) {
        return taskRepository.findByTaskId(taskId);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task userTaskUpdate(int taskId, Task task) {
        Task fetchTask = taskRepository.findByTaskId(taskId);
        if(fetchTask.getTaskId()==taskId){
            fetchTask.setStatus(task.getStatus());
        }
        return taskRepository.save(fetchTask);
    }

    @Override
    public List<Task> getAllTaskAgainstUser(int assignToId) {
        return taskRepository.findByAssignToId(assignToId);
    }

    @Override
    public Task updateTaskDetails(int taskId,Task task) {
        Task fetchTask = taskRepository.findByTaskId(taskId);
        if(fetchTask.getTaskId()==taskId){
            fetchTask.setStatus(task.getStatus());
            fetchTask.setTaskTitle(task.getTaskTitle());
            fetchTask.setDue_date(task.getDue_date());
            fetchTask.setPriority(task.getPriority());
            fetchTask.setAssignToId(task.getAssignToId());
        }
        return taskRepository.save(fetchTask);
    }
}
