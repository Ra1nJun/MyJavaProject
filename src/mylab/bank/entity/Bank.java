package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.*;

public class Bank {
	private List<Account> accounts = new ArrayList<>();
	private int nextAccountNumber = 1000;
	
	public Bank() {
        this.nextAccountNumber = 1000;
	}
	
	public String createSavingAccount(String ownerName, double initialBalance, double interestRate) {
		SavingAccount savingAC = new SavingAccount("AC"+nextAccountNumber++, ownerName, initialBalance, interestRate);
		accounts.add(savingAC);
		System.out.println("���� ���°� �����Ǿ����ϴ�: "+savingAC);
		return "���� ���°� �����Ǿ����ϴ�: "+savingAC;
	}
	
	public String createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
		CheckingAccount checkingAC = new CheckingAccount("AC"+nextAccountNumber++, ownerName, initialBalance, withdrawalLimit);
		accounts.add(checkingAC);
		System.out.println("üŷ ���°� �����Ǿ����ϴ�: "+checkingAC);
		return "üŷ ���°� �����Ǿ����ϴ�: "+checkingAC;
	}
	
	public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountNotFoundException("���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�.");
    }

    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }
	
    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException, WithdrawalLimitExceededException {
    	Account account = findAccount(accountNumber);
    	account.withdraw(amount);
    }
    
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException, WithdrawalLimitExceededException {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);
        
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        System.out.println(amount+"���� "+fromAccountNumber+"���� "+toAccountNumber+"�� �۱ݵǾ����ϴ�.");
    }
    
    public void printAllAccounts() {
    	for (Account account : accounts) {
			System.out.println(account);
		}
    }
    
}
