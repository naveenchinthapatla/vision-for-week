package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.project.model.Plan;
import com.project.repository.PlanRepository;

@Service
public class ScheduleService {
@Autowired
private PlanRepository planRepository;
@Autowired
private EmailService emailService;

//Sending Plan Email Template
public void sendPlan(String to, String subject, String body) {
	emailService.sendEmail(to, subject, body);
}


//Sunday Task
@Scheduled(cron = "0 45 09 * * *")
public void sun() {
	String subject = "Today's Plan - Sunday";
	List<Plan>allUsers = planRepository.findAll();
	for(Plan user : allUsers) {
		if(user.getSun().length() != 0) {
			sendPlan(user.getEmail(), subject, user.getSun()+"\nHave a nice day ahead.\n\nThanks & Regards\nVision For Week");
		}
	}
}


//Monday Task
@Scheduled(cron = "0 45 09 * * *")
public void mon() {
	String subject = "Today's Plan - Monday";
	List<Plan>allUsers = planRepository.findAll();
	for(Plan user : allUsers) {
		if(user.getMon().length() != 0) {
			sendPlan(user.getEmail(), subject, user.getMon()+"\nHave a nice day ahead.\n\nThanks & Regards\nVision For Week");
		}
	}
}

//Tuesday Task
@Scheduled(cron = "0 45 09 * * *")
public void tue() {
	String subject = "Today's Plan - Tuesday";
	List<Plan>allUsers = planRepository.findAll();
	for(Plan user : allUsers) {
		if(user.getTue().length() != 0) {
			sendPlan(user.getEmail(), subject, user.getTue()+"\nHave a nice day ahead.\n\nThanks & Regards\nVision For Week");
		}
	}
}

//Wednesday Task
@Scheduled(cron = "0 42 11 * * *")
public void wed() {
	String subject = "Today's Plan - Wednesday";
	List<Plan>allUsers = planRepository.findAll();
	for(Plan user : allUsers) {
		if(user.getWed().length() != 0) {
			sendPlan(user.getEmail(), subject, user.getWed()+"\nHave a nice day ahead.\n\nThanks & Regards\nVision For Week");
		}
	}
}

//Thursday Task
@Scheduled(cron = "0 00 10 * * *")
public void thu() {
	String subject = "Today's Plan - Thursday";
	List<Plan>allUsers = planRepository.findAll();
	for(Plan user : allUsers) {
		if(user.getThu().length() != 0) {
			sendPlan(user.getEmail(), subject, user.getThu()+"\nHave a nice day ahead.\n\nThanks & Regards\nVision For Week");
		}
	}
}

//Friday Task
@Scheduled(cron = "0 00 10 * * *")
public void fri() {
	String subject = "Today's Plan - Friday";
	List<Plan>allUsers = planRepository.findAll();
	for(Plan user : allUsers) {
		if(user.getFri().length() != 0) {
			sendPlan(user.getEmail(), subject, user.getFri()+"\nHave a nice day ahead.\n\nThanks & Regards\nVision For Week");
		}
	}
}

//Saturday Task
@Scheduled(cron = "0 00 10 * * *")
public void sat() {
	String subject = "Today's Plan - Saturday";
	List<Plan>allUsers = planRepository.findAll();
	for(Plan user : allUsers) {
		if(user.getSat().length() != 0) {
			sendPlan(user.getEmail(), subject, user.getSat()+"\nHave a nice day ahead.\n\nThanks & Regards\nVision For Week");
		}
	}
}
}
