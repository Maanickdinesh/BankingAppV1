package com.banking.entities;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="Account_Table")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "{account.name.absent}")
	@Pattern(regexp = "[A-Za-z]+([A-Za-z]+)*", message = "{account.name.invalid}")
        private String name;

	
	@NotNull(message = "{account.balance.absent}")
	@Range(min =10, max=100000,message="{account.balance.invalid}")
	private BigDecimal balance;
	
	@NotNull(message ="{account.phone.absent}")
	@Pattern(regexp = "[789][0-9]{9}", message ="{account.phone.invalid}")
	private String phone;
	
	@Email(message= "{account.email.invalid}")
	@NotNull(message ="{account.email.absent}")
	private String email;
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Account( String name, BigDecimal balance, String phone, String email) {
		super();
		
		this.name = name;
		this.balance = balance;
		this.phone = phone;
		this.email = email;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getBalance() {
		return balance;
	}


	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + ", phone=" + phone + ", email=" + email
				+ "]";
	}
	

}
