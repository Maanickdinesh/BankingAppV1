package com.banking.dto;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;

public class TransferDto {
 
	@NotNull(message = "{transferDto.accId.absent}")
	private Integer fromAccId;
	@NotNull(message = "{transferDto.accId.absent}")
	private Integer toAccId;
	
	@NotNull(message = "{transferDto.amount.absent}")
	@Range(min =10, max=100000,message="{transferDto.amount.invalid}")
	private BigDecimal amount;
	public TransferDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransferDto(Integer fromAccId, Integer toAccId, BigDecimal amount) {
		super();
		this.fromAccId = fromAccId;
		this.toAccId = toAccId;
		this.amount = amount;
	}
	public Integer getFromAccId() {
		return fromAccId;
	}
	public void setFromAccId(Integer fromAccId) {
		this.fromAccId = fromAccId;
	}
	public Integer getToAccId() {
		return toAccId;
	}
	public void setToAccId(Integer toAccId) {
		this.toAccId = toAccId;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "TransferDto [fromAccId=" + fromAccId + ", toAccId=" + toAccId + ", amount=" + amount + "]";
	}
	
	
}
