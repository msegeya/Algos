/**
	Question: ATM system

	Reference: Nothing specific found.

	Logic:
		Classes are Bank, Transaction, Account, Customer, ATM.

		Bank 			= bank code, bank address, manager and maintenance().
		Transaction 	= Transaction Id, Account Number, date, type, amount, post balance.
		Account			= Account name/number, Account type, Account balance, withdraw(), deposit()
		Customer		= Name, address, DOB, password, account number
		ATM 			= location, managed by, balance, transaction()

	How system works?
		- Customer goes to ATM, inserts card and enters amount.
		- ATM check the validity of the ATM card by account number and see's whether it has sufficient amount in ATM or not 
			and 
		  Checks whether customer has enough amount or not.
		- If both the above conditions are true then it returns the amount to the customer.
		- Creates a transaction and passes it to the bank.
		- Bank reads the transaction and deducts the amount from the account hodlder.
*/

class ATM {
	
}