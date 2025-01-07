package com.Redbus.Users.Repository;

import com.Redbus.Users.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

  //  UserEntity createUser();
}
