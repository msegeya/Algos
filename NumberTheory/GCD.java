/**
	GCD: Greatest Common Divisor.

	Logic: Use Euclid's Algorithm.
		GCD(A, B) = GCD(B, A % B) until B = 0.
*/

class GCD {
	public static void main(String[] args) {
		int a = 41;
		int b = 20;

		System.out.println(getGCD(a, b));
	}

	public static int getGCD(int a, int b) {
		return gcd(a, b);
	}

	public static int gcd(int a, int b) {
		if(b == 0) {
			return a;
		}

		return gcd(b, a % b);
	}
}