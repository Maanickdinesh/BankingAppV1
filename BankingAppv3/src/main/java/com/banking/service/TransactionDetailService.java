package com.banking.service;

import java.util.List;


import com.banking.entities.TransactionDetail;

public interface TransactionDetailService {

	public void addTranscationDetail(TransactionDetail transactiondetail);
	public List<TransactionDetail> getAll();
	public List<TransactionDetail> findByfromAccIdOrtoAccId(int accId);	
	
}
