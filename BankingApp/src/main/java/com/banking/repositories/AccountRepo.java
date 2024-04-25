package com.banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.entities.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>{

}
