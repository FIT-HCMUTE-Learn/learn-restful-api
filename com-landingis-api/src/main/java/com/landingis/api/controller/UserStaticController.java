package com.landingis.api.controller;

import com.landingis.api.bean.User;
import com.landingis.api.exception.UserNotFoundException;
import com.landingis.api.service.UserStaticService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserStaticController {

    @Autowired
    private UserStaticService userService;

    @GetMapping(path = {"/users"})
    public List<User> retrieveAllUsers(){
        return userService.findAll();
    }

    @GetMapping(path = {"/user/{id}"})
    public User retrieveUser(@PathVariable int id){
        User user = userService.findById(id);

        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }

        return user;
    }

    @PostMapping(path = {"/user"})
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userService.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id) {
        User user = userService.deleteById(id);

        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }
    }
}
