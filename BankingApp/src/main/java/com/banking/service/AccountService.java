package com.banking.service;

import java.math.BigDecimal;
import java.util.List;

import com.banking.entities.Account;

public interface AccountService {

	public List<Account> getAll();
	public Account addAccount(Account account);
	public Account getById(int accountId);
	
	public Account deleteById(int accountId);
	
	public void transfer(int fromAccId , int toAccId, BigDecimal amount);
	
	public void deposit(int accId,BigDecimal amount);
	
	public void withdraw(int accId,BigDecimal amount);
	
}
