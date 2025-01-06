package com.Redbus.Users.Repository;

import com.Redbus.Users.Entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepoImpl {

    @Autowired
    UserEntity userEntity;

    public UserEntity createUser() {
        return null;
    }
}
