package com.banking.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.dto.UserContacDetailtDto;
import com.banking.entities.UserEntity;
import com.banking.exceptions.ResourceNotFoundException;
import com.banking.repositories.UserRepo;
import com.banking.service.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional

public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userrepo;
	@Override
	public List<UserEntity> findall() {
		// TODO Auto-generated method stub
		
		return userrepo.findAll();
	}


	@Override
	public void addUserEntity(UserEntity userentity) {
		// TODO Auto-generated method stub
		userrepo.save(userentity);
	}

	@Override
	public void deleteUserEntity(UserEntity userentity) {
		// TODO Auto-generated method stub
		userrepo.delete(userentity);
	}

	@Override
	public void updateContactDto(UserContacDetailtDto usercontacdetailtdto) {
		// TODO Auto-generated method stub
		
		UserEntity userToUpdate = getByid(usercontacdetailtdto.getId());
		userToUpdate.setAddress(usercontacdetailtdto.getAddress());
	    userToUpdate.setEmail(usercontacdetailtdto.getEmail());
	    userToUpdate.setPhone(usercontacdetailtdto.getPhone());
	}


	@Override
	public UserEntity findByusername(String username) {
		// TODO Auto-generated method stub
		return userrepo.findByusername(username);
	}


	@Override
	public UserEntity getByid(int id) {
		// TODO Auto-generated method stub
		
		return userrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
	}

}
