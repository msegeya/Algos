/**
	Question: Facade Design Pattern.

	Reference: https://www.youtube.com/watch?v=B1Y8fcYrz5o

	Application:
		- If you want to design a simplified interface where there are many other operations that are performed behind the scenes that are not shown.

	Explanation: 
		- Suppose you went to a ATM and want to withdraw money. You just enter your account-number/card and pin/password.
		- That's it. Rest of the operations like,
			1) Check card validity.
			2) Check pin number with the card number.
			3) Check account is valid or not.
			4) Check if the entered amount is present or not.
			5) Do operations after withdrawal like debit the total amount with the withdrawal amount and release the card that is inserted.
		- All the above opearations that are mentioned runs in the background.
		- In simple a Facade pattern is nothing but having an interface that is simple but behind the scenes there are many scenarios running.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacadePattern {
	public static void main(String[] args) {
		String accountNumber = "12345";
		String pwd = "1234";
		BankAccountFacade baf = new BankAccountFacade(accountNumber, pwd);
		
		// Total present in the account will be 100.
		// withdraw amount 100.
		baf.withdraw(500);
		// withdraw amount 200.
		baf.withdraw(700);
	}
} 


class BankAccountFacade {
	
	private WelcomeBank welcomeBank;
	private AccountNumberCheck anc;
	private SecurityCheck sc;
	public Transaction trans;
	
	public BankAccountFacade(String accountNumber, String pwd) {
		welcomeBank = new WelcomeBank();
		anc = new AccountNumberCheck();
		sc = new SecurityCheck();
		trans = new Transaction();
		
		if(anc.accountNumberCheck(accountNumber) && sc.securityCheck(accountNumber, pwd)) {
			
		} else {
			return;
		}
	}
	
	public void withdraw(int amount) {
		trans.withdraw(amount);
	}
}

class WelcomeBank {
	public WelcomeBank() {
		System.out.println("Welcome to bank.");
	}
}

class AccountNumberCheck {
	static List<String> accounts;
	String[] accountNumbers = {"12345", "67890", "12987"};
	
	public AccountNumberCheck() {
		if(null == accounts) {
			accounts = new ArrayList<String>();
			accounts.addAll(Arrays.asList(accountNumbers));
		}
	}
	
	public boolean accountNumberCheck(String accountNumber) {
		if(accounts.contains(accountNumber)) {
			System.out.println("Account " + accountNumber + " is present.");
			return true;
		} else {
			System.out.println("Account " + accountNumber + " is NOT present.");
			return false;
		}
	}
}

class SecurityCheck {
	static Map<String, String> pwdMap;
	
	public SecurityCheck() {
		if(null == pwdMap) {
			pwdMap = new HashMap<String, String>();
			pwdMap.put("12345", "1234");
			pwdMap.put("67890", "6789");
			pwdMap.put("12987", "1298");
		}
	}
	
	public boolean securityCheck(String accountNumber, String pin) {
		String pwd = pwdMap.get(accountNumber);
		if(null != pwd) {
			if(pwd.equals(pin)) {
				System.out.println("Account is logged in.");
				return true;
			}
		}
		System.out.println("Wrong password. Account cannot be logged.");
		return false;
	}
}

class Transaction {
	public static int total = 1000;
	
	public int withdraw(int amount) {
		if(total - amount >= 0) {
			total = total - amount;
			System.out.println("Amount " + amount + " is debited from your account");
			System.out.println("Remaining balance is " + total);
			return amount;
		} else {
			System.out.println("You don't have enough balance.");
			return -1;
		}
	}
	
	public void credit(int amount) {
		total += amount;
		System.out.println("Amount " + amount + " has been credited to your account.");
	}
}