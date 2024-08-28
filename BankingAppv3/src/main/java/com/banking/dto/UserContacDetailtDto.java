package com.banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserContacDetailtDto {

	private int id;
	private String address;
	private String email;
	private String phone;
	
}
