/**
	Question: Factory Design Pattern.

	Reference: http://www.javatpoint.com/factory-method-design-pattern

	Applications:
		- Pattern decides dynamically which object should be created based on the request.
		- Pattern allows loose-coupling. How? so that it will work with any classes that implement that interface.

	Explanation: 
		- Consider the scenario where we have telecom plans such as domestic or international.
		- When a user enters based on his request we will calculate the bill. That is if the user asks for international plans then we will calculate the rate according to International plans.
		- Similarly we will do the same for Domestic plans.
*/

class FactoryPattern {
	public static void main(String[] args) {
		String user1 = "Domestic";
		String user2 = "International";
		
		Plans_Factory p1 = MyFactory.getInstance(user1);
		p1.setRate();
		p1.calculateBill(100); // calculate for 100 units using domestic rates.
		
		Plans_Factory p2 = MyFactory.getInstance(user2);
		p2.setRate();
		p2.calculateBill(100); // calculate for 100 units using international rates.
	}
}

class MyFactory {
	
	public static final String DOMESTIC = "Domestic";
	public static final String INTERNATIONAL = "International";
	
	public static Plans_Factory getInstance(String planType) {
		if(null == planType) { return null; }
		
		if(planType == DOMESTIC) {
			return new DomesticPlans_Factory();
		} else if(planType == INTERNATIONAL) {
			return new InternationalPlans_Factory();
		} else {
			return null;
		}
	}
}

abstract class Plans_Factory {
	protected double rate;

	abstract public void setRate();

	public void calculateBill(int units) {
		System.out.println(rate * units);
	}
}

// We have different rates so we select rates based on the user request.
class DomesticPlans_Factory extends Plans_Factory {

	@Override
	public void setRate() {
		rate = 3.50;
	}
	
}

// We have different rates so we select rates based on the user request.
class InternationalPlans_Factory extends Plans_Factory {

	@Override
	public void setRate() {
		rate = 10.20;
	}
}