package com.task.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Task {

    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;

    @Column(name = "task_title")
        private String taskTitle;

    @Column(name = "assign_to_id")
    private int assignToId;

    @Column(name = "task_status")
    private String status;

    @Column(name = "task_priority")
    private String priority;

    @Column(name = "task_endDate")
    private Date due_date;

    @Column(name = "create_on")
    private Date createdOn;

    @Column(name = "created_by")
    private int createdBy;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public int getAssignToId() {
        return assignToId;
    }

    public void setAssignToId(int assignToId) {
        this.assignToId = assignToId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Task() {
    }

    public Task(int taskId, String taskTitle, int assignToId, String status, String priority, Date due_date, Date createdOn, int createdBy) {
        this.taskId = taskId;
        this.taskTitle = taskTitle;
        this.assignToId = assignToId;
        this.status = status;
        this.priority = priority;
        this.due_date = due_date;
        this.createdOn = createdOn;
        this.createdBy = createdBy;
    }
}
