package mylab.bank.entity;

public class SavingAccount extends Account{
	private double interestRate;
	
	public SavingAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
		super.Account(accountNumber, ownerName, initialBalance);
		this.interestRate = interestRate;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public void applyInterest() {
		double InterestPayments = super.getBalance()*(interestRate/100);
		deposit(InterestPayments);
		System.out.println("���� "+InterestPayments+"���� ����Ǿ����ϴ�. ���� �ܾ�: "+super.getBalance());
	}
	
	@Override
	public String toString() {
		return super.toString()+", ������: "+interestRate+"%";
	}
}
