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
		System.out.println("저축 계좌가 생성되었습니다: "+savingAC);
		return "저축 계좌가 생성되었습니다: "+savingAC;
	}
	
	public String createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
		CheckingAccount checkingAC = new CheckingAccount("AC"+nextAccountNumber++, ownerName, initialBalance, withdrawalLimit);
		accounts.add(checkingAC);
		System.out.println("체킹 계좌가 생성되었습니다: "+checkingAC);
		return "체킹 계좌가 생성되었습니다: "+checkingAC;
	}
	
	public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
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
        System.out.println(amount+"원이 "+fromAccountNumber+"에서 "+toAccountNumber+"로 송금되었습니다.");
    }
    
    public void printAllAccounts() {
    	for (Account account : accounts) {
			System.out.println(account);
		}
    }
    
}
