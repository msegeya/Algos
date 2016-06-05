/**
	Question: Finally block is always reached even when you write return in try as well as catch blocks.
	Only way to escape finally block is by using System.exit(1);
*/

class FinallyEx {
	public static void main(String[] args) {
		System.out.println(concat("1", "two"));
		System.out.println("\n\n");
		System.out.println(concat("1", null));
	}

	public static String concat(String s1, String s2) {
		try {
			String s3 = s1 + s2.length();
			System.out.println("In Try Block. ==> " + s3);

			// Only way to exit finally block is by using System.exit(1);
			// System.exit(1);

			return "try";
		} catch(Exception e) {
			String s3 = s1 + s2;
			System.out.println("In Catch Block. ==> " + s3);

			// Only way to exit finally block is by using System.exit(1);
			// System.exit(1);

			return "catch";
		} finally {
			System.out.println("In Finally block");
			return "finally";
		}
	}
}
