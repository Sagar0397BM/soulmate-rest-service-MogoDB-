package com.stackroute.soulMateDemo.controller;

import com.stackroute.soulMateDemo.Domain.User;

import com.stackroute.soulMateDemo.Exceptions.UserAlradyExistsException;

import com.stackroute.soulMateDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) throws UserAlradyExistsException, Exception {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() throws Exception {
        return new ResponseEntity<List<User>>((List<User>) userService.getAllUser(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) throws NoSuchElementException, Exception {
        userService.deleteUser(id);
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public User userById(@PathVariable int id) throws NoSuchElementException, Exception {
        Optional<User> user = userService.getUserById(id);
        return user.get();
    }

    @PutMapping("/users/update/{id}")
    public ResponseEntity<User> updateById(@PathVariable int id, @RequestBody User user) throws NoSuchElementException, Exception {
        userService.updateUser(id, user);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/users/search/{age}")
    public ResponseEntity<List<User>> UserByAge(@PathVariable int age) {
        return new ResponseEntity<List<User>>((List<User>) userService.findUserByAge(age), HttpStatus.OK);

    }
}