package com.banking;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.banking.entities.Account;
import com.banking.service.AccountService;

@SpringBootApplication
public class BankingAppApplication implements CommandLineRunner {
	@Autowired
	private AccountService accountservice;

	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//accountservice.addAccount(new Account("Suresh", BigDecimal.valueOf(5000),"9626567461","suresh@gmail.com"));
//		accountservice.addAccount(new Account("surya", BigDecimal.valueOf(7000),"8026297461","surya@gmail.com"));
//       System.out.println("Account Added");
		
	}

}
