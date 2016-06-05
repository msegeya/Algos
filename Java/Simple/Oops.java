class Oops {
	
	/************************ Abstraction - START **************************/
	// Abstraction: Hiding internal details and showing functionality is known as abstraction.
	// Example: Abstraction is the quality of dealing with ideas rather than events. for example when you consider the case of e-mail, complex details such as what happens soon you send an e-mail, the protocol your email server uses are hidden from the user, therefore to send an e-mail you just need to type the content, mention the address of the receiver and click send.
	/************************ Abstraction - END **************************/

	/************************ Encapsulation - START **************************/
	// Encapsulation: Binding (or wrapping) code and data together into a single unit is known as encapsulation.
	// In the below example, num cannot be accessed directly we should use getters/setters to access num. This is binding the data with the code.
	private int num;
	public int getNum() { return num; }
	public void setNum() { return num; }
	/************************ Encapsulation - END **************************/

	/************************ Inheritance - START **************************/
	// Inheritance - When one object acquires all the properties and behaviours of parent object i.e. known as inheritance.
	// We can achieve it using "implementing interface" or "extending a class"
	interface Animal {
	   public void eat();
	   public void travel();
	}

	class MammalInt implements Animal{

	   	public void eat(){
	      System.out.println("Mammal eats");
	   	}

	   	public void travel(){
	      System.out.println("Mammal travels");
	   	} 

	   	public int noOfLegs(){
	      return 0;
	   	}

	   	public static void main(String args[]){
	      MammalInt m = new MammalInt();
	      m.eat();
	      m.travel();
	   	}
	} 
	/************************ Inheritance - END **************************/

	/************************ Polymorphism - START **************************/
	// Ploymorphism - Polymorphism means one name, many forms. In Java, we use method overloading and method overriding to achieve polymorphism.
	// We have both compile time Ploymorphism (overloading) and runtime polymorphism(overriding).

	// Runtime Polymorphism example. (Overriding)
	class Animal { public float run_speed(); }
	class Tiger implements animal { public float run_speed() { return 100.20; } }

	// Compile time polymorphism. (Overloading)
	class Calculator { 
		public int add(int a, int b) { return a + b; } 
		public float add(float a, float b) { return a + b; } 
	}
	/************************ Polymorphism - END **************************/	
}