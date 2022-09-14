package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project.model.User;
@Component
public interface SignUpRepository extends JpaRepository<User,String>{

}
