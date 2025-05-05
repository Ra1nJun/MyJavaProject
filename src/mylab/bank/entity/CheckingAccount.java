package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
	private double withdrawalLimit;
	
	public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double withdrawalLimit) {
		super.Account(accountNumber, ownerName, initialBalance);
		this.withdrawalLimit = withdrawalLimit;
	}

	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}
	
	public void withdraw(double amount) throws WithdrawalLimitExceededException, InsufficientBalanceException {
		if (amount > withdrawalLimit) {
			String errMessage = String.format("���� �߻�: ��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: %.1f",withdrawalLimit);
			throw new WithdrawalLimitExceededException(errMessage);
		}
		super.withdraw(amount);
	}
	
	@Override
	public String toString() {
		return super.toString()+", ����ѵ�: "+withdrawalLimit+"��";
	}
}
