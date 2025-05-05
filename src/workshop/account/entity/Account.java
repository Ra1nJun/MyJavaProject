package workshop.account.entity;

import workshop.account.exception.InsufficientBalanceException;

public class Account {
	private String custId;
	private String acctId;
	private int balance;
	
	//������
	public Account() {
		System.out.println("Default Constructor");
	}
	//������ �ߺ� ����
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
	
	//�Ա�
	public void deposit(int amount) {
		this.balance += amount;
	}
	//���
	public void withdraw(int amount) throws InsufficientBalanceException {
		if (amount > balance) {
			String errMessage = String.format("�ܾ��� �����մϴ�. (��û �ݾ�: %d, ���� �ܾ� %d)",amount,balance);
			throw new InsufficientBalanceException(errMessage);
		}
		this.balance -= amount;
	}
	
	//�θ� ���� Object�� toString() �ż��� ������
	@Override
	public String toString() {
		return "Account [custId=" + custId + ", acctId=" + acctId +
				", balance=" + balance + "]";
	}
	
}
