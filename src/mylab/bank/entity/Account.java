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
		System.out.println(amount+"���� �ԱݵǾ����ϴ�. ���� �ܾ�: "+balance+"��");
	}
	
	public void withdraw(double amount) throws InsufficientBalanceException, WithdrawalLimitExceededException {
		if (amount > balance) {
			String errMessage = String.format("���� �߻�: �ܾ��� �����մϴ�. ���� �ܾ� %.1f",balance);
			throw new InsufficientBalanceException(errMessage);
		}
		this.balance -= amount;
		System.out.println(amount+"���� ��ݵǾ����ϴ�. ���� �ܾ�: "+balance+"��");
	}
	
	public String toString() {
		return "���¹�ȣ: "+accountNumber+", ������: "+ownerName+", �ܾ�: "+balance;
	}
}
