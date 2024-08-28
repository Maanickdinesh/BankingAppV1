package com.banking.service;

import java.util.List;

import com.banking.dto.UserContacDetailtDto;
import com.banking.entities.UserEntity;

public interface UserService {

	public List<UserEntity> findall(); // return type is list 
	public UserEntity getByid(int id); 
	public UserEntity findByusername(String username);

	public void addUserEntity(UserEntity userentity);
	public void deleteUserEntity(UserEntity userentity);
	public void updateContactDto(UserContacDetailtDto usercontacdetailtdto);
}
