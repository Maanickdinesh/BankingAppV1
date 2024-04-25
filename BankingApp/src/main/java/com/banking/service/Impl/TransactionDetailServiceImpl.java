package com.banking.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entities.TransactionDetail;
import com.banking.repositories.TransactionDetailsRepo;
import com.banking.service.TransactionDetailService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TransactionDetailServiceImpl  implements TransactionDetailService{
 
	@Autowired
	private TransactionDetailsRepo detailrepo;
	@Override
	public void addTranscationDetail(TransactionDetail transactiondetail) {
		// TODO Auto-generated method stub
		detailrepo.save(transactiondetail);
	}

	@Override
	public List<TransactionDetail> getAll() {
		// TODO Auto-generated method stub
		return detailrepo.findAll();
	}

	@Override
	public List<TransactionDetail> findByfromAccIdOrtoAccId(int accId) {
		// TODO Auto-generated method stub
		return detailrepo.findByFromAccIdOrToAccId(accId, accId);
	}

	
	

}
