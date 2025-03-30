package com.userservice.entity;

import com.userservice.entity.taskClient.Task;
import jakarta.persistence.*;

@Entity
public class UserEntity {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "user_name")
    private String username;

    @Column(name = "user_email")
    private String useremail;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    transient private Task task;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public UserEntity() {
    }

    public UserEntity(int userId, String username, String useremail, String password, String role) {
        this.userId = userId;
        this.username = username;
        this.useremail = useremail;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", useremail='" + useremail + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
