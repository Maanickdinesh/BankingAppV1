package com.banking.API;

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

import com.banking.entities.UserEntity;
import com.banking.service.UserService;

@RestController
@RequestMapping(path ="api/usermgt")
public class AppUserApi {

	@Autowired
	private UserService userservice;
	
	@GetMapping(path ="users")
	public List<UserEntity> getAll(){
		return userservice.findall();
	}
	
	@GetMapping(path ="user/{id}")
	public UserEntity getanuser( @PathVariable int id) {
		return userservice.getByid(id);
	}
	
	@PostMapping(path ="users")
	public ResponseEntity<String> adduser(@RequestBody UserEntity userentity)
	{
		userservice.addUserEntity(userentity);
		return ResponseEntity.status(HttpStatus.CREATED).body("New Bank User Created");
	}
	
}
