package mylab.bank.control;

import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingAccount;

public class BankDemo {
	public static void main(String[] args) {
		Bank bank = new Bank();
		
		System.out.println("==계좌 생성==");
		bank.createSavingAccount("홍길동", 10000, 3);
		bank.createCheckingAccount("김철수", 20000, 5000);
		bank.createSavingAccount("이영희", 30000, 2);
		System.out.println();
		
		System.out.println("==모든 계좌 목록==");
		bank.printAllAccounts();
		System.out.println("============");
		System.out.println();
		
		try {
			System.out.println("==입금/출금 테스트==");
			bank.deposit("AC1000", 5000);
			bank.withdraw("AC1001", 3000);
			System.out.println();
			
			System.out.println("== 이자 적용 테스트 ==");
			((SavingAccount)bank.findAccount("AC1000")).applyInterest();
			System.out.println();
			
			System.out.println("==계좌 이체 테스트==");
			bank.transfer("AC1002", "AC1001", 5000);
			System.out.println();
			
			System.out.println("==모든 계좌 목록==");
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
