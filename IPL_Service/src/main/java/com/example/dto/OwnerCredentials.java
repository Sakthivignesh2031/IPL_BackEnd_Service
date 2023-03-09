package com.example.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OwnerCredentials {
	
	
	private String userName;
	private String email;
	private String userPassword;

}
