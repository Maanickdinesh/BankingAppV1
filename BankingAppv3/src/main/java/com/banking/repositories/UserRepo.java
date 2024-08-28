package com.banking.repositories;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.entities.UserEntity;

public interface UserRepo  extends JpaRepository<UserEntity, Integer>{

	public UserEntity findByusername(String username);
	
}
