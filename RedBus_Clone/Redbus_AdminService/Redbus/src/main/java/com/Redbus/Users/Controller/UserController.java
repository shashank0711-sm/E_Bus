package com.Redbus.Users.Controller;


import com.Redbus.Users.Entity.UserEntity;
import com.Redbus.Users.Service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/UserService")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserServiceImpl userService;

    // add new user
    @PostMapping("/addUser")
    private ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
        logger.info("Request at Controller - Add user ");
        try {
            this.userService.createEntity(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all users
    @GetMapping("/getAllUser")
    public List<UserEntity> getAllUser(){
        logger.info("Request at Controller - Get all user ");
        return this.userService.getUser();
    }

    // update user
    @PutMapping("/updateUser/{id}")
    public UserEntity updateUser(@RequestBody UserEntity user, @PathVariable Long id){
        logger.info("Request at Controller - Update user ");
         return this.userService.updateUser(user,id);
       //  return new ResponseEntity<>(HttpStatus.OK);
    }

    //delete user
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable Long id){
        logger.info("Request at Controller - Delete user ");
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
