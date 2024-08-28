package com.banking.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.banking.dto.AccountContacDetailtDto;
import com.banking.entities.Account;
import com.banking.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "api/accountmgt")
public class AccountManagementApi {

	@Autowired
	private AccountService accountService;

	@PostMapping(path = "accounts")
	public ResponseEntity<Account> addAccount( @Valid  @RequestBody Account account) {

		accountService.addAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(account);
	}

	@PutMapping(path = "accounts")
	public ResponseEntity<String> updateAccount( @Valid  @RequestBody AccountContacDetailtDto accountcontactdetaildto) {
		accountService.updateAccountContactDetail(accountcontactdetaildto);
		return ResponseEntity.status(HttpStatus.OK)
				.body("Conatct details of customer " + accountcontactdetaildto.getAccId() + " is changed successfully");
	}

	// -----------get all accounts----------
	@GetMapping(path = "accounts")
	public List<Account> getAllAccount() {
		return accountService.getAll();
	}

	// ---get an specific account----
    @GetMapping(path ="accounts/{accountId}")
	public Account getAccountById(@PathVariable int accountId) {
		return accountService.getById(accountId);
	}
    
    // delete an account 
    @DeleteMapping(path = "accounts/{accountId}")
    public  ResponseEntity<Void> deleteAccountById( @PathVariable int accountId){
    	accountService.deleteById(accountId);
    	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
