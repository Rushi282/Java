package entity;

import java.io.Serializable;
import java.util.ArrayList;

import custom_exception.IllegalAmountException;
import custom_exception.InsufficientFundException;
import custom_exception.MaxWithdrawLimitExceedException;
import utils.Transaction;

@SuppressWarnings("serial")
public class Account implements Serializable {
	private String accNum;
	private double bal;
	private static long id;
	private static double minBal;
	private double maxWithLimit;
	
	static {
		id = 1000;
		minBal = 5000;
	}
	
	public Account() {
		bal = minBal;
	}
	
	public Account(String accNum, double bal) {
		super();
		this.accNum = accNum;
		this.bal = bal;
		maxWithLimit = 50000;
	}

	public String getAccNum() {
		return accNum;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	public double getMaxWithLimit() {
		return maxWithLimit;
	}

	public void setMaxWithLimit(double maxWithLimit) {
		this.maxWithLimit = maxWithLimit;
	}
	
	public Account createAccount() {
		accNum = "Cdac"+ ++id;
		Account acc = new Account(accNum,bal);
		return acc; 
	}
	
	public void deposit(double amt) throws IllegalAmountException {
		if(amt<=0) {
			throw new IllegalAmountException("Amount is less than 0");
		}else {
			bal+=amt;
			ArrayList<Account> accounts = new ArrayList<Account>();
			accounts.add(this);
			Transaction.recordDepositTransaction(amt, accounts);
			System.out.println(amt+" Credited to "+this.getAccNum()+", Avalable balance: "+this.getBal());
		}
	}
	
	public void withdraw(double amt) throws IllegalAmountException, InsufficientFundException, MaxWithdrawLimitExceedException {
		if(amt<=0) {
			throw new IllegalAmountException("Amount is less than 0");
		} else if((bal-amt)<5000) {
			throw new InsufficientFundException("Minimun 5000 amount required");
		} else if(amt>maxWithLimit) {
			throw new MaxWithdrawLimitExceedException("Amount is greater than 50000, max withdrawl limit: "+maxWithLimit);
		} else {
			bal-=amt;
			ArrayList<Account> accounts = new ArrayList<Account>();
			accounts.add(this);
			Transaction.recordWithdrawTransaction(amt, accounts);
			System.out.println(amt+" Debited from "+this.getAccNum()+", Avalable balance: "+this.getBal());
		}
	}
	
	public void applyIntrest(float rate) {
		double intAmt = bal*rate;
		bal+=intAmt;
	}

	@Override
	public String toString() {
		return "Account [accNum=" + accNum + ", bal=" + bal + ", maxWithLimit=" + maxWithLimit + "]";
	}

}
