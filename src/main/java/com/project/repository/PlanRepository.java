package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.project.model.Plan;
@Component
public interface PlanRepository extends JpaRepository<Plan,String>{

}
