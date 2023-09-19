package com.practice.login_register.repositories;

import com.practice.login_register.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

//    List<User> findAll(); // don't need in this practice scenario

        Optional<User> findByEmail(String email); // find any user with the given email
}
