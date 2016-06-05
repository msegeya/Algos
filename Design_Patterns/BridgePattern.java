/**
	Question: Bridge Design Pattern.

	Reference:  https://dzone.com/articles/design-patterns-bridge			
				http://www.tutorialspoint.com/design_pattern/bridge_pattern.htm
				http://www.journaldev.com/1491/bridge-pattern-in-java-example-tutorial
				https://www.youtube.com/watch?v=9jIgSsIfh_8

	Definition: 
		- Bridge is used when we need to decouple an abstraction from its implementation so that the two can vary independently ... that is when the abstract class is changed the interface should not get effected similarly when the implementation is changed the abstract class should not get changed.
		- This pattern involves an interface which acts as a bridge which makes the functionality of concrete classes independent from interface implementer classes. Both types of classes can be altered structurally without affecting each other.

	Bridge in the Real World:
		The display of different image formats on different operating systems is a good example of the Bridge pattern. You might have different image abstractions for both jpeg and png images. The image structure is the same across all operating systems, but the how it's viewed (the implementation) is different on each OS. This is the type of decoupling that the Bridge pattern allows.

	Explanation: 
		- First, we have our TV implementation interface.
		- And then we create two specific implementations - one for Sony and one for Philips. These classes deal with the specific implementations of the TV from each vendor. 
		- Now, we create a remote control  abstraction to control the TV. As the remote control holds a reference to the TV, it can delegates the methods through to the interface. But what is we want a more specific remote control - one that has the + / - buttons for moving through the channels? All we need to do is extend our RemoteControl abstraction to contain these concepts
*/

public class BridgePattern {
	public static void main(String[] args) {
		Shape redCircle = new Circle(10, 100, 100, new RedCircle());
		Shape greenCircle = new Circle(10, 100, 100, new GreenCircle());
		
		redCircle.draw();
		greenCircle.draw();
	}
}

interface DrawAPI {
	public void draw(int radius, int x, int y);
}

class RedCircle implements DrawAPI {
	@Override
	public void draw(int radius, int x, int y) {
		System.out.println("Draw RED Circle with radius " + radius);
	}
}

class GreenCircle implements DrawAPI {
	@Override
	public void draw(int radius, int x, int y) {
		System.out.println("Draw GREEN Circle with radius " + radius);
	}
}

abstract class Shape {
	protected DrawAPI drawApi;
	
	public Shape(DrawAPI drawApi) {
		this.drawApi = drawApi;
	}
	
	public abstract void draw();
}


class Circle extends Shape {

	private int x, y, radius;
	
	public Circle(int radius, int x, int y, DrawAPI drawApi) {
		super(drawApi);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public void draw() {
		drawApi.draw(radius, x, y);
	}
}