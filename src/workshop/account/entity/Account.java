package workshop.account.entity;

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
	public void withdraw(int amount) {
		if (amount > balance) {
			System.out.println("�ܾ׺���");
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
