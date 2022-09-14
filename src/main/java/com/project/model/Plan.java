package com.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users_plans")
public class Plan {
@NotBlank
@Id
@NotNull
private String email;
@Lob
private String sun,
mon,tue,wed,thu,
fri, sat;
}
