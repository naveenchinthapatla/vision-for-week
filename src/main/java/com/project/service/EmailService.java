package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class EmailService {
@Autowired
private JavaMailSender javaMailSender;

public void sendEmail(String to, String subject, String body) {
	SimpleMailMessage message = new SimpleMailMessage();
	message.setFrom("visionforweek@gmail.com");
	message.setTo(to);
	message.setSubject(subject);
	message.setText(body);
	javaMailSender.send(message);
}
}
