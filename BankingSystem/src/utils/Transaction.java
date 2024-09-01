package utils;

import java.util.ArrayList;

import custom_exception.IllegalAmountException;
import custom_exception.IllegalTransferException;
import custom_exception.InsufficientFundException;
import custom_exception.MaxWithdrawLimitExceedException;
import entity.Account;

public class Transaction {

	public static void transfer(Account ac1, Account ac2, double amt) throws IllegalTransferException,
			IllegalAmountException, InsufficientFundException, MaxWithdrawLimitExceedException {
		if (ac1 == ac2) {
			throw new IllegalTransferException("Both accounts are same");
		} else if (amt <= 0) {
			throw new IllegalAmountException("Amount is less than 0");
		} else {
			ac1.withdraw(amt);
			ac2.deposit(amt);
			ArrayList<Account> accounts = new ArrayList<Account>();
			accounts.add(ac1);
			accounts.add(ac2);
			recordTransferTransaction(amt, accounts);
		}
	}

	public static void enforceWithdrawalLimit(Account account, double amt) {
		if (amt < account.getMaxWithLimit()) {
			System.out.println("amount is less than of your current limit");
		} else {
			account.setMaxWithLimit(amt);
			System.out.println("Withdrawal Limit updated: "+account.getMaxWithLimit());
		}
	}

	static ArrayList<TransactionRecord> transactionRecords = new ArrayList<>();

	public static void recordDepositTransaction(double amt, ArrayList<Account> accounts) {
		transactionRecords.add(new TransactionRecord("Deposit", accounts, amt));
	}

	public static void recordWithdrawTransaction(double amt, ArrayList<Account> accounts) {
		transactionRecords.add(new TransactionRecord("Withdraw", accounts, amt));
	}

	public static void recordTransferTransaction(double amt, ArrayList<Account> accounts) {
		transactionRecords.add(new TransactionRecord("Transfer", accounts, amt));
	}

	public static ArrayList<TransactionRecord> getTransactions() {
		return transactionRecords;
	}
}
