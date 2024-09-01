package bank;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import custom_exception.IllegalAmountException;
import custom_exception.InsufficientFundException;
import custom_exception.MaxWithdrawLimitExceedException;
import entity.Account;
import entity.Customer;
import utils.Transaction;
import utils.TransactionRecord;

public class BankDriver {

	public static Account getValidAccount(String userAccountNum, Customer[] customers) {
		for (Customer customer : customers) {
			if (customer.acc.getAccNum().equals(userAccountNum)) {
				return customer.acc;
			}
		}
		return null;
	}

	static final String BANK_NAME = "Java Bank";

	public static void main(String[] args) throws IllegalAmountException, InsufficientFundException, MaxWithdrawLimitExceedException {
		Scanner sc = new Scanner(System.in);
		System.out.println("========= Welcome to " + BANK_NAME + " =========");
		System.out.println("Enter size of bank: ");
		int maxSize = sc.nextInt();
		Customer[] customers = new Customer[maxSize];
		int count = 0;
		boolean exit = true;
		while (exit) {
			System.out.println(
					"Select choice: \n1.Add Cusomer.\n2.Deposit.\n3.Withdraw.\n4.Transfer.\n5.Get all customers.\n6.Get transactions.\n7.Account statment.\n10.Exit");
			int ch = sc.nextInt();
			switch (ch) {
			case 1: {
				if (count < maxSize) {
					System.out.println("++ Register new Customer ++");
					System.out.println("Enter name, address, mobile number");
					customers[count] = new Customer(sc.next(), sc.next(), sc.nextLong(), new Account().createAccount());
					System.out.println(customers[count]);
					count++;
				} else {
					System.out.println("Sorry bank is full.");
				}
				break;
			}
			case 2: {
				System.out.println("Enter account number");
				String accNum = sc.next();
				Account validAcc = getValidAccount(accNum, customers);
				if (validAcc != null) {
					System.out.println("Enter amount to deposit: ");
					validAcc.deposit(sc.nextDouble());
				} else {
					System.out.println("Account not found.");
				}
//				int flag = 0;
//				for (Customer customer : customers) {
//					if(customer.acc.getAccNum().equals(accNum)) {
//						System.out.println("Enter amount to deposit: ");
//						customer.acc.deposit(sc.nextDouble());
//						flag = 1;
//						break;
//					}
//				}
//				if(flag == 0) {
//					System.out.println("Account not found.");
//				}
				break;
			}
			case 3: {
				System.out.println("Enter account number");
				String accNum = sc.next();
				Account validAcc = getValidAccount(accNum, customers);
				if (validAcc != null) {
					System.out.println("Enter amount to withdraw: ");
					try {
						validAcc.withdraw(sc.nextDouble());
					} catch (IllegalAmountException | InsufficientFundException | MaxWithdrawLimitExceedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("Account not found.");
				}
				break;
			}
			case 4: {
				System.out.println("Enter sender account number: ");
				String senderNum = sc.next();
				Account senderAcc = getValidAccount(senderNum, customers);
				System.out.println("Enter receiver account number: ");
				String receverNum = sc.next();
				Account receiverAcc = getValidAccount(receverNum, customers);
				if(senderAcc != null && receiverAcc != null) {
					System.out.println("Enter amount: ");
					double amt = sc.nextDouble();
					try {
						Transaction.transfer(senderAcc, receiverAcc, amt);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				break;
			}
			case 5: {
				for (Customer customer : customers) {
					System.out.println(customer);
				}
				break;
			}
			case 6: {
				ArrayList<TransactionRecord> transactionRecords = Transaction.getTransactions();
				try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("D:\\March-24\\Course\\Java\\Demos\\BankingSystem\\src\\utils\\Transactions.txt"));) {
					for (TransactionRecord record : transactionRecords) {
						System.out.println(record);
						outputStream.writeObject(record.toString()+"\n");
						
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
			}
			case 7:{
				System.out.println("Enter account number");
				String accNum = sc.next();
				Account validAcc = getValidAccount(accNum, customers);
				ArrayList<TransactionRecord> transactionRecords = Transaction.getTransactions();
				for (TransactionRecord record : transactionRecords) {
					if(record.getAccounts().contains(validAcc)) {
						System.out.println(record);
					}
				}
				List<?> transactions = transactionRecords.stream()
						.filter(r -> r.getAccounts().contains(validAcc))
						.map(r -> r.getClass())
						.collect(Collectors.toList());
				 System.out.println(transactions.toString());
				break;
			}
			case 10: {
				exit = false;
				break;
			}

			default:
				System.out.println("Illegal choice...!!! try again.");
				break;
			}
		}
		System.out.println("Thank you visit again..!!");
		sc.close();
	}

}

// Jack Kolhapur 7588249523
// Jill Pune 1236547896
