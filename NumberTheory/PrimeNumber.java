/**
	Question: Find whether the given number is prime or not.

	Logic: 
		- If there is a divisor of N that is less than square root of N then there will be a divisor of N that is greater than square root of N. Therefore, we just need to traverse till the square root of N.
		- In the below code instead of square root we are using the square.
*/

class PrimeNumber {
	public static void main(String[] args) {
		int[] array = {2, 3, 4, 5, 6, 9, 11, 14, 17, 19};
		for(int num : array) {
			
			int count = 0;
			for(int i = 1; i * i <= num; i++) {
				if(num % i == 0) {
					if(i * i == num) {
						count++;
					} else {
						count += 2;
					}
				}	
			}

			if(count > 2) {
				System.out.println(num + "\tNot a Prime Number.");
			} else {
				System.out.println(num + "\tIs a Prime Number.");
			}
		}
	}
}