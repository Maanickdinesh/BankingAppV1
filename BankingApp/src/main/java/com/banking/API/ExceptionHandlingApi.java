package com.banking.API;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.MethodArgumentBuilder;

import com.banking.dto.ErrorDetails;
import com.banking.exceptions.BankAccountNotFoundException;

@RestControllerAdvice
public class ExceptionHandlingApi {
    @ExceptionHandler(BankAccountNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleBankAccountNOtFoundException(BankAccountNotFoundException ex){
		
    	
    	ErrorDetails errordetails = new ErrorDetails.ErrorDetailsBuilder()
				.errorMessage(ex.getMessage())
                .errorCode(HttpStatus.NOT_FOUND.toString())
                .toContact("Dinesh@gmail.com")
                .timestamp(LocalDateTime.now())
                .build();
				
		
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errordetails);
	}
//    @ExceptionHandler(Exception.class)
//	public ResponseEntity<ErrorDetails> handle500(Exception ex){
//		
//		ErrorDetails errordetails = new ErrorDetails.ErrorDetailsBuilder()
//				.errorMessage("Server Error")
//                .errorCode(HttpStatus.NOT_FOUND.toString())
//                .toContact("Dinesh@gmail.com")
//                .timestamp(LocalDateTime.now())
//                .build();
//				
//		
//		
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errordetails);
//	}
    
    
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> handle400(MethodArgumentNotValidException ex){
		
    	
    	String errorMessage = ex.getBindingResult().getAllErrors().stream()
    	        .map(e -> e.getDefaultMessage())
    	        .collect(Collectors.joining(", "));
    	
		ErrorDetails errordetails = new ErrorDetails.ErrorDetailsBuilder()
				.errorMessage(errorMessage)
                .errorCode(HttpStatus.BAD_REQUEST.toString())
                .toContact("Dinesh@gmail.com")
                .timestamp(LocalDateTime.now())
                .build();
				
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errordetails);
	}
    
}
