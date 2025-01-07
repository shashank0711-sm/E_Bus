package com.Redbus.Users.Service;

import com.Redbus.Users.Controller.UserController;
import com.Redbus.Users.Entity.UserEntity;
import com.Redbus.Users.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;

    public UserEntity createEntity(UserEntity user){
       logger.info("Inside User Service - Create User");
       return userRepository.save(user);
    }

    public List<UserEntity> getUser(){
        logger.info("Inside User Service - Get All Users");
        return userRepository.findAll();
    }

    public UserEntity updateUser(UserEntity user,Long id) {
        logger.info("Inside User Service - Update User");
        UserEntity user1=userRepository.findById(id).orElse(null);
        if(user1!=null){
            user1.setUserName(user.getUserName());
            user1.setGender(user.getGender());
            user1.setEmail(user.getEmail());
        }
        return userRepository.save(user1);
    }

    public void deleteUser(Long id) {
        logger.info("Inside User Service - Delete User "+id);
        UserEntity user = userRepository.findById(id).orElse(null);
        if(user!=null){
            userRepository.deleteById(id);
        }
    }
}

