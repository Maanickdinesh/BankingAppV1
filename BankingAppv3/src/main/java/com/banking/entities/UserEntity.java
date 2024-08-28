package com.banking.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.annotation.Generated;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name="user_table")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name ="user_roles")
	private List<String> roles = new ArrayList<>();
	
	
	private String address;
	private String email;
	private String phone;
	public UserEntity(String username, String password, List<String> roles, String address, String email,
			String phone) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	
	
	
}
