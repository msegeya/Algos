/**
	Question: Abstract Factory Design Pattern.

	Applications:
		Same as Factory Pattern. But in a more abstract sense.

	Factory_Pattern Vs Abstract_Factory_Pattern:
	1) 	With the Factory pattern, you produce implementations (Apple, Banana, Cherry, etc.) of a particular interface -- say, IFruit.
		With the Abstract Factory pattern, you produce implementations of a particular Factory interface -- e.g., IFruitFactory. Each of those knows how to create different kinds of fruit.
	2)  Factory pattern: The factory produces IProduct-implementations
		Abstract Factory Pattern: A factory-factory produces IFactories, which in turn produces IProducts.

	Explanation: 
		- Consider that you want to take a loan.
		- Two cases arise here, 
			1) From which bank.
			2) What kind of loan.
		- Each of the above is a factory pattern. That is Bank will hold various concrete banks and loan will have various different types of loans.
		- So abstract is nothing but a colelction of different factory patterns.
*/

class AbstractFactory {
	public static void main(String[] args) {
		Abstract_Factory af = FactoryCreator.getFactory("Bank");
		Bank bank = af.getBank("HDFC");
		System.out.println("Selected Bank Name is: " + bank.getBankName());
		
		af = FactoryCreator.getFactory("Loan");
		Loan loan = af.getLoanRate("EDU");
		// say HDFC interest rate is 2/-		
		int interestRate = 2;
		loan.getInterestRate(interestRate);
		System.out.println("HDFC interest for Education loan is as below: ");
		loan.calLoanAmount(1000, 2);
		
		System.out.println();
	}
}

/* Bank interface and concrete implementations. - START */
interface Bank {
	public String getBankName();
}

class HDFC implements Bank {
	public String name;
	public HDFC() { this.name = "HDFC"; } 
	
	@Override
	public String getBankName() {
		return name;  
	}
}

class SBI implements Bank {
	public String name;
	public SBI() { this.name = "SBI"; }
	
	@Override
	public String getBankName() {
		return name;
	}
}
/* Bank interface and concrete implementations. - END */

/* Loan interface and concrete implementations. - START */
abstract class Loan {
	protected double rate;
	abstract void getInterestRate(double rate);
	
	public void calLoanAmount(int loanAmount, int years) {
		int months = years * 12;
		rate = rate / 1200;
		double EMI = ((rate*Math.pow((1+rate), months))/((Math.pow((1+rate), months))-1)) * loanAmount;
		System.out.println("Total Amount " + loanAmount + "\nEMI is " + EMI);
	}
}

class EducationLoan extends Loan {
	@Override
	void getInterestRate(double rate) {
		this.rate = rate; 
	}
}

class CarLoan extends Loan {
	@Override
	void getInterestRate(double rate) {
		this.rate = rate;
	}
}
/* Loan interface and concrete implementations. - END */

/* Abstract Factory which has both factory's such as Bank and Loan. - START */
abstract class Abstract_Factory {
	public abstract Bank getBank(String name); 
	public abstract Loan getLoanRate(String name);
}

class MyBankFactory extends Abstract_Factory {
	private static final String SBI = "SBI";
	private static final String HDFC = "HDFC";
	
	public Bank getBank(String name) {
		if(SBI == name) {
			return new SBI();
		} else if(HDFC == name) {
			return new HDFC();
		} else {
			return null;
		}
	}

	@Override
	public Loan getLoanRate(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}

class MyLoanFactory extends Abstract_Factory {
	private static final String CAR_LOAN = "CAR";
	private static final String EDU_LOAN = "EDU";
	public Loan getLoanRate(String name) {
		if(name == CAR_LOAN) {
			return new CarLoan();
		} else if(EDU_LOAN == name) {
			return new EducationLoan();
		} else {
			return null;
		}
	}
	@Override
	public Bank getBank(String name) {
		// TODO Auto-generated method stub
		return null;
	} 
}
/* Abstract Factory which has both factory's such as Bank and Loan. - END */

/* A factory to return the Bank and Loan instances. - START */
class FactoryCreator {
	public static Abstract_Factory getFactory(String name) {
		if(name == "Bank") {
			return new MyBankFactory();
		} else if(name == "Loan") {
			return new MyLoanFactory();
		} else {
			return null;
		}
	}
}
/* A factory to return the Bank and Loan instances. - END */
