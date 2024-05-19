package com.banking.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name="Transaction_detail_table")
@Entity
public class TransactionDetail {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int fromAccId;
	private int toAccId;
	@Enumerated(EnumType.STRING)
	private TransactionType txType;
	
	private LocalDateTime datetime;
	private String authority;
	public TransactionDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionDetail( int fromAccId, int toAccId, TransactionType txType, LocalDateTime datetime,
			String authority) {
		super();
		
		this.fromAccId = fromAccId;
		this.toAccId = toAccId;
		this.txType = txType;
		this.datetime = datetime;
		this.authority = authority;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFromAccId() {
		return fromAccId;
	}
	public void setFromAccId(int fromAccId) {
		this.fromAccId = fromAccId;
	}
	public int getToAccId() {
		return toAccId;
	}
	public void setToAccId(int toAccId) {
		this.toAccId = toAccId;
	}
	public TransactionType getTxType() {
		return txType;
	}
	public void setTxType(TransactionType txType) {
		this.txType = txType;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Override
	public String toString() {
		return "TransactionDetail [id=" + id + ", fromAccId=" + fromAccId + ", toAccId=" + toAccId + ", txType="
				+ txType + ", datetime=" + datetime + ", authority=" + authority + "]";
	}
	

}
