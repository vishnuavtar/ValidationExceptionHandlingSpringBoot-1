package com.example.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

	
	@NotBlank(message = "Username should not be null")
	private String name;
	
	@Email(message = "invalid email")
	private String email;
	@NotNull
	@Pattern(regexp = "^\\d{10}$" , message = "{invalid mobile number}")
	private String mobile;
	
	
	private String gender;
	
	@Max(60)
	private int age;
	
	@NotBlank
	private String nationality;
	
	
}
