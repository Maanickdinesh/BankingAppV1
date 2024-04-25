package com.banking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.entities.TransactionDetail;

@Repository
public interface TransactionDetailsRepo extends JpaRepository<TransactionDetail, Integer>{
	public List<TransactionDetail> findByFromAccIdOrToAccId(int fromAccId, int toAccId);
}
