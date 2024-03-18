package com.priyanshu.userinfo.controller;

import com.priyanshu.userinfo.dto.UserDTO;
import com.priyanshu.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO){
        UserDTO newUserDTO = userService.addUser(userDTO);
        return new ResponseEntity<>(newUserDTO, HttpStatus.CREATED);
    }

    @GetMapping("/fetchUserById/{userId}")
    public ResponseEntity<UserDTO> fetchUserById(@PathVariable("userId") Integer userId ){
        return userService.fetchUserById(userId);
    }
}
