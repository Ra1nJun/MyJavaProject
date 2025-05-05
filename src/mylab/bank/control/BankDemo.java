package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingAccount;

public class BankDemo {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		System.out.println("==���� ����==");
		bank.createSavingAccount("ȫ�浿", 10000, 3);
		bank.createCheckingAccount("��ö��", 20000, 5000);
		bank.createSavingAccount("�̿���", 30000, 2);
		System.out.println();
		
		System.out.println("==��� ���� ���==");
		bank.printAllAccounts();
		System.out.println("============");
		System.out.println();
		
		try {
			System.out.println("==�Ա�/��� �׽�Ʈ==");
			bank.deposit("AC1000", 5000);
			bank.withdraw("AC1001", 3000);
			System.out.println();
			
			System.out.println("== ���� ���� �׽�Ʈ ==");
			((SavingAccount)bank.findAccount("AC1000")).applyInterest();
			System.out.println();
			
			System.out.println("==���� ��ü �׽�Ʈ==");
			bank.transfer("AC1002", "AC1001", 5000);
			System.out.println();
			
			System.out.println("==��� ���� ���==");
			bank.printAllAccounts();
			System.out.println("============");
			
			bank.withdraw("AC1001", 6000);
			System.out.println();			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			bank.withdraw("AC1001", 20000);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			bank.findAccount("AC9999");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
