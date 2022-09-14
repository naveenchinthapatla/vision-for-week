
package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.project.service.PlanService;

@EnableScheduling
@SpringBootApplication
public class ProjectApplication {

public static void main(String[] args) {
	SpringApplication.run(ProjectApplication.class, args);
}
}
