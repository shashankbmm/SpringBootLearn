package com.shashank.SpringBootEverything.controller;

import com.shashank.SpringBootEverything.model.User;
import com.shashank.SpringBootEverything.model.UserDto;
import com.shashank.SpringBootEverything.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("getUserByID/{ID}")
    public ResponseEntity<User> getUserByID(@PathVariable Integer ID){
        User user = userService.getUserByID(ID);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    @PostMapping("createUser")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDto userDto){
        User user1 = userService.createUser(userService.mapToUser(userDto));
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @PutMapping("updateUser/{ID}")
    public ResponseEntity<User> updateUser(@PathVariable Integer ID, @RequestBody UserDto userDto){
        User user1 = userService.updateUser(ID, userService.mapToUser(userDto));
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @DeleteMapping("deleteUser/{ID}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer ID){
        String result = userService.deleteUser(ID);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
