package com.userservice.controller;

import com.userservice.config.CustomUserDetailsService;
import com.userservice.config.JWTHelper;
import com.userservice.controller.login.JWTRequest;
import com.userservice.controller.login.JWTResponse;
import com.userservice.entity.UserEntity;
import com.userservice.entity.taskClient.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.userservice.services.UserServce;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServce userServce;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    //Following AuthenticationManager we fetch from Config(CentralConfig) file, there we create one bean for this.
    //Following used for to Authenticate
    @Autowired
    private AuthenticationManager authenticationManager;

    //Used for to create JWT.
    @Autowired
    private JWTHelper jwtHelper;

    @PostMapping("/saveUser")
    public ResponseEntity<UserEntity> saveUserDetails(@RequestBody UserEntity user) {
        UserEntity savedUser = userServce.add(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/getUser/{id}")
    public UserEntity getSpecificUser(@PathVariable int id){
        return userServce.get(id);
    }

    @GetMapping("/getCreaterPerson/{id}")
    public UserEntity getCreaterPerson(@PathVariable int id){
        return userServce.get(id);
    }

    @PostMapping("/login")
    public ResponseEntity<JWTResponse> login(@RequestBody JWTRequest request) {

        this.doAuthenticate(request.getEmail(), request.getPassword());


        UserDetails userDetails = customUserDetailsService.loadUserByUsername(request.getEmail());

        String token = this.jwtHelper.generateToken(userDetails);

        System.out.println("Check Token: "+ token);
        JWTResponse jwtResponse = new JWTResponse(token, userDetails.getUsername());

        return new ResponseEntity<>(jwtResponse, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            authenticationManager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

    //Following Request only for user(Service Engineer)
    @PutMapping("/taskStatus/{id}")
    public Task updateTaskStatus(@PathVariable int id, @RequestBody Task task){
        return userServce.updateTaskStatus(id, task);
    }

    //Following Request only for user(admin and Team Leader)
    @PostMapping("/addTask")
    public Task addNewTask(@RequestBody Task task){
        return userServce.addNewTask(task);
    }

    

}
