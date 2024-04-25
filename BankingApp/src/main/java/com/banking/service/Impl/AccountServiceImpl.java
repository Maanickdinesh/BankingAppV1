package com.banking.service.Impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entities.Account;
import com.banking.exceptions.BankAccountNotFoundException;
import com.banking.repositories.AccountRepo;
import com.banking.service.AccountService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo accountrepo;

	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return accountrepo.findAll();
	}

	@Override
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		accountrepo.save(account);
		return account;
	}

	@Override
	public Account getById(int accountId) {
		// TODO Auto-generated method stub
		return accountrepo.findById(accountId)
				.orElseThrow(() -> new BankAccountNotFoundException("Bank account with id" + accountId + "is not fount")

				);
	}

	@Override
	public Account deleteById(int accountId) {
		// TODO Auto-generated method stub
		Account accountTODelete = getById(accountId);
		accountrepo.delete(accountTODelete);
		return accountTODelete;
	}

	@Override
	public void transfer(int fromAccId, int toAccId, BigDecimal amount) {
		// TODO Auto-generated method stub
		
		Account fromAcc = getById(fromAccId);
		Account toAcc = getById(toAccId);
		
		fromAcc.setBalance(fromAcc.getBalance().subtract(amount));
		toAcc.setBalance(toAcc.getBalance().add(amount));
           
	   accountrepo.save(fromAcc);
	   accountrepo.save(toAcc);
	}

	@Override
	public void deposit(int accId, BigDecimal amount) {
		// TODO Auto-generated method stub
		Account acc = getById(accId);
	    BigDecimal currentBalance = acc.getBalance();
	    
	    // Logging: Print current balance before modification
	    System.out.println("Current balance before deposit: " + currentBalance);
	    
	    // Check if currentBalance is null
	    if (currentBalance == null) {
	        // If it's null, initialize it to zero
	        currentBalance = BigDecimal.ZERO;
	    }
	    
	    // Logging: Print amount to be deposited
	    System.out.println("Depositing amount: " + amount);
	    
	    // Add the amount to the current balance
	    acc.setBalance(currentBalance.add(amount));
	    
	    // Logging: Print updated balance after deposit
	    System.out.println("Updated balance after deposit: " + acc.getBalance());
	    
	    // Save the updated account
	    accountrepo.save(acc);

	}

	@Override
	public void withdraw(int accId, BigDecimal amount) {
		// TODO Auto-generated method stub
        Account acc= getById(accId);
        acc.setBalance(acc.getBalance().subtract(amount));
        accountrepo.save(acc);
	}

}
