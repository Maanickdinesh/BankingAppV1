package com.banking.API;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.dto.DepositeDto;
import com.banking.dto.TransferDto;
import com.banking.dto.WithdrawDto;
import com.banking.entities.TransactionDetail;
import com.banking.entities.TransactionType;
import com.banking.service.AccountService;
import com.banking.service.TransactionDetailService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path ="api/transaction")
public class AccountTransactionApi {
   @Autowired
	AccountService accountService;
   @Autowired
   TransactionDetailService detailservice;
   
   @GetMapping(path ="transactiondetails")
   public List<TransactionDetail> getallTransactionDetail(){
	  return  detailservice.getAll();
   }
   
   @GetMapping(path = "transactiondetails/{accountid}")
   public List<TransactionDetail> getTransactionDetailAnySpecifiAccount(@PathVariable (name="accountid")int accountid){
	   return detailservice.findByfromAccIdOrtoAccId(accountid);
   }
   
	@PostMapping(path ="transfer")
	public ResponseEntity<String> transfer( @Valid @RequestBody TransferDto transferdto) {
		
		accountService.transfer(transferdto.getFromAccId(), transferdto.getToAccId(), transferdto.getAmount());
		
		detailservice.addTranscationDetail(new TransactionDetail(transferdto.getFromAccId(),transferdto.getToAccId(),TransactionType.TRANSFER,LocalDateTime.now(),"Dinesh"));
		
		return ResponseEntity.status(HttpStatus.OK)
		.body("Fund is transfer from account id" + transferdto.getFromAccId()+" to Account id"+transferdto.getToAccId());
		
		
	}
	@PostMapping(path ="deposit")
	public ResponseEntity<String> deposite( @Valid @RequestBody DepositeDto depositedto){
		accountService.deposit(depositedto.getAccId(), depositedto.getAmmount());
		
		detailservice.addTranscationDetail(new TransactionDetail(0,depositedto.getAccId(),TransactionType.DEPOSITE,LocalDateTime.now(),"Dinesh"));
		
		return ResponseEntity.status(HttpStatus.OK)
	    .body("Fund is deposited to Account id"+ depositedto.getAccId()+"Amount is "+depositedto.getAmmount());
	}
	@PostMapping(path ="withdraw")
	public ResponseEntity<String> withdraw( @Valid  @RequestBody WithdrawDto withdrawdto){
		accountService.withdraw(withdrawdto.getAccId(), withdrawdto.getAmount());
		
		detailservice.addTranscationDetail(new TransactionDetail(withdrawdto.getAccId(),0,TransactionType.WITHDRAW,LocalDateTime.now(),"Dinesh"));

	
		return ResponseEntity.status(HttpStatus.OK)
		.body("Amount Withdraw from "+ withdrawdto.getAccId()+"amount is" +withdrawdto.getAmount());
	}
}
