package workshop.account.entity;

import workshop.account.exception.InsufficientBalanceException;

public class Account {
	private String custId;
	private String acctId;
	private int balance;
	
	//생성자
	public Account() {
		System.out.println("Default Constructor");
	}
	//생성자 중복 정의
	public Account(String custId, String acctId, int balance) {
		this.custId = custId;
		this.acctId = acctId;
		this.balance = balance;
	}

	
	//setter
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	
	//getter
	public String getCustId() {
		return custId;
	}
	public String getAcctId() {
		return acctId;
	}
	public int getBalance() {
		return balance;
	}
	
	//입금
	public void deposit(int amount) {
		this.balance += amount;
	}
	//출금
	public void withdraw(int amount) throws InsufficientBalanceException {
		if (amount > balance) {
			String errMessage = String.format("잔액이 부족합니다. (요청 금액: %d, 현재 잔액 %d)",amount,balance);
			throw new InsufficientBalanceException(errMessage);
		}
		this.balance -= amount;
	}
	
	//부모가 가진 Object의 toString() 매서드 재정의
	@Override
	public String toString() {
		return "Account [custId=" + custId + ", acctId=" + acctId +
				", balance=" + balance + "]";
	}
	
}
