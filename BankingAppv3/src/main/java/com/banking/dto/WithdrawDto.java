package com.banking.dto;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;

public class WithdrawDto {
	
	@NotNull(message = "{withdrawDto.accId.absent}")
	private int accId;
	
	@NotNull(message = "{withdrawDto .amount.absent}")
	@Range(min =10, max=100000,message="{withdrawDto.amount.invalid}")
	private BigDecimal amount;
	public WithdrawDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WithdrawDto(int accId, BigDecimal amount) {
		super();
		this.accId = accId;
		this.amount = amount;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "WithdrawDto [accId=" + accId + ", amount=" + amount + "]";
	}
	

}
