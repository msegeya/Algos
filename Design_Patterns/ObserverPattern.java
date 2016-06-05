/**
	Question: Observer Pattern.

	Reference: https://www.youtube.com/watch?v=wiQdrH2YpT4

	Applicaiton: 
		- Stock Market: Thousands of stocks needs to send update when objects representing individual stocks.
		 				The observers may take one or many and use them.
		- Advantages: 
			1) Loose coupling. The subject (publisher) doesn't need to know  anything about the observers(subscribers).
			2) Negative point is that the subject may send updates to the observer that don't matter to observer.
		- One more real world example is some thing like petrol prices. All the franchises of Shell petrol will get notified when ever there is a change in the petrol prices.

	Explanation: 
		- When ever you need many other objects to receive an update  when another object chnages.
		- Consider the following example, if center changes the tax of a product then all states should get notified and change the prices accordingly.
		- So when ever center changes the tax rate all the states will get notified and all the states will display their new prices.

	- Another real world example is RBI changing interest rates. All the banks will be observers and RBI will be the subject.
*/

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
	public static void main(String[] args) {
		Center_Subject subject = new Center_Subject();
		
		new AndhraPradesh_Observer(subject);
		new Karnataka_Observer(subject);
		
		subject.setRate(5);
		System.out.println("------------------------------------------------");
		subject.setRate(10);
		System.out.println("------------------------------------------------");
		subject.setRate(15);
		System.out.println("------------------------------------------------");
	}
}

class Center_Subject {
	public List<States_Observer> observers = new ArrayList<States_Observer>();
	public int rate;
	
	public int getRate() {
		return rate;
	}
	
	public void setRate(int rate) {
		System.out.println("Center changed tax to " + rate);
		this.rate = rate;
		// the moment you set new rate at center notify all observers.
		notifyAllObservers();
	}
	
	private void notifyAllObservers() {
		for(States_Observer obs : observers) {
			obs.update(rate);
		}
	}
	
	public void attach(States_Observer observer) {
		observers.add(observer);
	}
}

abstract class States_Observer {
	// all the states must add themselves to the center.
	protected Center_Subject subject; 
	abstract public void update(int nationalRate);
}

class Karnataka_Observer extends States_Observer {
	// states have their own price.	
	public int stateRate = 10; 
	
	public Karnataka_Observer(Center_Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}
	
	@Override
	public void update(int nationalRate) {
		System.out.println("Karnataka Petrol Price: " + (stateRate + nationalRate));
	}
}

class AndhraPradesh_Observer extends States_Observer {
	// states have their own price.
	public int stateRate = 8;
	
	public AndhraPradesh_Observer(Center_Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}
	
	@Override
	public void update(int nationalRate) {
		System.out.println("Andhra Pradesh Petrol Price: " + (stateRate + nationalRate));
	}
}