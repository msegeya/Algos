/**
	Question: Decorator Design Pattern

	Reference: http://www.journaldev.com/1540/decorator-pattern-in-java-example-tutorial

	Definition: 
		- Decorator pattern allows a user to add new functionality to an existing object without altering its structure. This type of design pattern comes under structural pattern as this pattern acts as a wrapper to existing class.
		- Allows you to modify the object dynamically. 
		- When you want to add the functionalities at runtime.
		- It is most flexible than inheritance.

	Explanation: 
		- Consider a Car. Car is an interface and we need to assemble based on the request.
		- Take two types of cars like Sports Car and Luxury Car.
		- Now for any car we need basic car features + other features depending on the car type like Sports car or Luxury Car.
		- First we will create a class which will actually create a basic car features .. (see class CarDecorator)
		- Then if the car is sports car then it will extend the basic car features from CarDecorator and then it will add additional features depending on the car needs. (see SportsCar and LuxuryCar)
*/

public class DecoratorPattern {
	public static void main(String[] args) {
		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		
		System.out.println("***************************************************");
		
		Car luxuryCar = new LuxuryCar(new BasicCar());
		luxuryCar.assemble();
	}
}

interface Car {
	void assemble();
}

class BasicCar implements Car {
	@Override
	public void assemble() {
		System.out.println("Basic Car");
	}
}

// Decorator class implements the component interface and it has a HAS-A relationship with the component interface. 
// The component variable should be accessible to the child decorator classes, so we will make this variable protected.
class CarDecorator implements Car {

	protected Car car;
	
	public CarDecorator(Car car) {
		this.car = car;
	}
	
	@Override
	public void assemble() {
		this.car.assemble();
	}
	
}

class SportsCar extends CarDecorator {
	public SportsCar(Car c) {
		super(c);
	}
	
	@Override
	public void assemble() {
		car.assemble();
		System.out.println("Adding Sports-Car features.");
	}
}

class LuxuryCar extends CarDecorator {
	
	public LuxuryCar(Car car) {
		super(car);
	}
	
	@Override
	public void assemble() {
		car.assemble();
		System.out.println("Adding Luxury-Car features.");
	}
}