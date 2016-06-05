/**
	Source: http://www.tutorialspoint.com/java/java_generics.htm

	Description:
		- All generic method declarations have a type parameter section delimited by angle brackets (< and >) that precedes the method's return type.
			Example: <E> func(E param_name)

		- Each type parameter section contains one or more type parameters separated by commas. A type parameter, also known as a type variable, is an identifier that specifies a generic type name.
			Example: <E> func(E[] array)

		- The type parameters can be used to declare the return type and act as placeholders for the types of the arguments passed to the generic method, which are known as actual type arguments.
			Example: <E> func(..)

		- A generic method's body is declared like that of any other method. Note that type parameters can represent ONLY REFERENCE TYPES, NOT PRIMITIVE TYPES (like int, double and char).

*/

class GenericTest {

	public static void main(String[] args) {
		Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.println("\nGeneric Test: Integer array: ");
        printValue(intArray);

		System.out.println("\nGeneric Test: Double array: ");
        printValue(doubleArray);

        System.out.println("\nGeneric Test: Character array: ");
        printValue(charArray);

        System.out.println("\nGeneric Return Type: Integer Array: ");
       	System.out.println(addTwoNums(intArray[0], intArray[1]));

       	System.out.println("\nGeneric Return Type: Character Array: ");
       	System.out.println(addTwoNums(doubleArray[0], doubleArray[1]));
	}

	// Case-1: Print the array by type.
	// Method without return type.
	static <E> void printValue(E[] array) {
		for(E element : array) {
			System.out.print(element + " ");
		}
	}

	// Case-2: Get sum of generics 
	// Method with return type.
	/**
		Suppose we need to add two generics then how do we do it?
		Always remember while we are performing some operations we need to keep track of the generics.
		Here, if we add two params of generic type. We cannot just add them since we don't know what the generic types are. What if the params are tow objects of a class. Can we add them? NO. So before doing some operation on the generics make sure they successed when performing the operation by converting them to needed type.

		We can't use "instanceOf" in Generics.
		"There is no way to find out the runtime type of generic type parameters in Java."
	*/
	static <E extends Number> double addTwoNums(E input1, E input2) {
		return input1.doubleValue() + input2.doubleValue(); 
	}
}