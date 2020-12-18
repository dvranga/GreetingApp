package com.bridgelabz.greetingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.greetingapp.model.User;

public interface UserRepository extends JpaRepository<User,Long>  {

}

