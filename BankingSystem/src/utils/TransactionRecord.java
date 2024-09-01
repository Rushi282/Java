package utils;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

import entity.Account;

@SuppressWarnings("serial")
public class TransactionRecord implements Serializable{
	private String transactionId;
	private String transactionType;
	private ArrayList<Account> accounts;
	private double amt;
	private LocalDateTime TransactionDateTime;
	private static long id = 5000;
	
	public TransactionRecord() {
		
	}

	public TransactionRecord(String transactionType, ArrayList<Account> accounts, double amt) {
		super();
		this.transactionId = "Tr"+ ++id;
		this.transactionType = transactionType;
		this.accounts = accounts;
		this.amt = amt;
		TransactionDateTime = LocalDateTime.now();
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public double getAmt() {
		return amt;
	}

	public void setAmt(double amt) {
		this.amt = amt;
	}

	public LocalDateTime getTransactionDateTime() {
		return TransactionDateTime;
	}

	public void setTransactionDateTime(LocalDateTime transactionDateTime) {
		TransactionDateTime = transactionDateTime;
	}

	@Override
	public String toString() {
		return "TransactionRecord [transactionId=" + transactionId + ", transactionType=" + transactionType
				+ ", accounts=" + accounts + ", amt=" + amt + ", TransactionDateTime=" + TransactionDateTime + "]";
	}
	
}
