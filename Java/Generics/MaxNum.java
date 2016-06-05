/**
	Source: http://www.tutorialspoint.com/java/java_generics.htm

	Description: 
		There may be times when you'll want to restrict the kinds of types that are allowed to be passed to a type parameter. For example, a method that operates on numbers might only want to accept instances of Number or its subclasses. This is what bounded type parameters are for.
		To declare a bounded type parameter, list the type parameter's name, followed by the extends keyword, followed by its upper bound.

*/

class MaxNum {
	public static void main(String[] args) {
		Integer[] intArray = {1, 2, 3};
		Double[] doubleArray = {1.1, 2.2, 3.3};
		Character[] charArray = {'a', 'b', 'c'};

		System.out.println("\nInteger Comparison: ");
		System.out.println(maxValue(intArray[0], intArray[1], intArray[2]));

		System.out.println("\nDouble Comparison: ");
		System.out.println(maxValue(doubleArray[0], doubleArray[1], doubleArray[2]));		

		System.out.println("\nCharacter Comparison: ");
		System.out.println(maxValue(charArray[0], charArray[1], charArray[2]));	

		// Negative case
		//System.out.println("Negative Case: ");
		//Object[] objectArray = {new Object(), new Object(), new Object()};
		//System.out.println(maxValue(objectArray[0], objectArray[1], objectArray[2]));
		// This does not work because we wrote "Comparable", which acts as a constraint.
		// As we can't compare two object without the actual content so this won't work.
	}

	static <E extends Comparable<E>> E maxValue(E x, E y, E z) {
		E max = x;

		if(y.compareTo(max) > 0) {
			max = y;
		}

		if(z.compareTo(max) > 0) {
			max = z;
		}

		return max;
	}

}