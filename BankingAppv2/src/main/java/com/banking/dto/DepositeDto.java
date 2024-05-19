package com.banking.dto;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotNull;

public class DepositeDto {
 
	@NotNull(message = "{depositeDto.accId.absent}")
	private int accId;
	
	@NotNull(message = "{depositeDto.ammount.absent}")
	@Range(min =10, max=100000,message="{depositeDto.ammount.invalid}")
	private BigDecimal ammount;
	
	public DepositeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DepositeDto(int accId, BigDecimal ammount) {
		super();
		this.accId = accId;
		this.ammount = ammount;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public BigDecimal getAmmount() {
		return ammount;
	}
	public void setAmmount(BigDecimal ammount) {
		this.ammount = ammount;
	}
	@Override
	public String toString() {
		return "DepositeDto [accId=" + accId + ", ammount=" + ammount + "]";
	}
	
	
}
