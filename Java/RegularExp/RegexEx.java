import java.util.regex.*;

class RegexEx {
	public static void main(String[] args) {
		// Pattern p will be our regex expression.
		Pattern p = Pattern.compile(".s");

		// Matcher m will be the actual input string that we need to check against the Pattern.
		Matcher m_positive = p.matcher("as");

		boolean result = m_positive.matches();

		// Positive case
		System.out.println(result);

		// Negative case
		Matcher m_negative = p.matcher("amarnath");
		result = m_negative.matches();
		System.out.println(result);

		// Negative case
		Matcher m_negative_2 = p.matcher("s");
		result = m_negative_2.matches();
		System.out.println(result);		
	}
}