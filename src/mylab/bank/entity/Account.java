package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class Account {
	private String accountNumber;
	private String ownerName;
	private double balance;
	
	public void Account(String accountNumber, String ownerName, double balance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println(amount+"원이 입금되었습니다. 현재 잔액: "+balance+"원");
	}
	
	public void withdraw(double amount) throws InsufficientBalanceException, WithdrawalLimitExceededException {
		if (amount > balance) {
			String errMessage = String.format("예외 발생: 잔액이 부족합니다. 현재 잔액 %.1f",balance);
			throw new InsufficientBalanceException(errMessage);
		}
		this.balance -= amount;
		System.out.println(amount+"원이 출금되었습니다. 현재 잔액: "+balance+"원");
	}
	
	public String toString() {
		return "계좌번호: "+accountNumber+", 소유자: "+ownerName+", 잔액: "+balance;
	}
}
