package com.codewithnihaal.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithnihaal.blog.entities.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
