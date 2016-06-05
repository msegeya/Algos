/**
	Question: Stratergy Pattern. (Behaviour Pattern)

	Reference: http://www.tutorialspoint.com/design_pattern/strategy_pattern.htm

	Explanation: 
		- In Strategy pattern, we create objects which represent various strategies and a context object whose behavior varies as per its strategy object. The strategy object changes the executing algorithm of the context object.
		- We need not mention about any the actual object that needs to be initiated.
*/

interface Stratergy {
	public void doOperation(int num1, int num2);
}

class Add_Context implements Stratergy {
	public void doOperation(int num1, int num2) {
		System.out.println("Add Operation: " + (num1 + num2));
	}
}

class Substract_Context implements Stratergy {
	@Override
	public void doOperation(int num1, int num2) {
		System.out.println("Substract Operation: " + (num1 - num2));
	}
}

class Context {
	public Stratergy stratergy;
	public Context(Stratergy stratergy) {
		this.stratergy = stratergy;
	}
	
	public void executeOperation(int num1, int num2) {
		this.stratergy.doOperation(num1, num2);
	}
}


public class StratergyPattern {
	public static void main(String[] args) {
		Context context = new Context(new Add_Context());
		context.executeOperation(10, 20);
		
		context = new Context(new Substract_Context());
		context.executeOperation(10, 20);
	}
}
