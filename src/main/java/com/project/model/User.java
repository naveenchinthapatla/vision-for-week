package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
private String firstName;
private String lastName;

@Id
private String email;
private String password;
private String conPassword;

}
