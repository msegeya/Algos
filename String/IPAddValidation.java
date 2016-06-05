/**
	Question: Validate given IP address.

	Reference: http://www.mkyong.com/regular-expressions/how-to-validate-ip-address-with-regular-expression/
				http://stackoverflow.com/questions/5667371/validate-ipv4-address-in-java

	Logic: 
		- We have 4 parts in a IP address. [0-255].[0-255].[0-255].[0-255]
		- First 3 parts have a dot after them except the last part.
		- Also note everything is of same format.
		- We will use Regular Expression. Consider only one part, other parts are same except the last part where we don't have a dot at the end.
		- [0 - 255]:
			# The string may have one digit, two digit, three digit.
			# If one digit, it can be anythign between [0-9]
			# If two digits, it can be anything between [0-99]
			# It three digits, it has to be starting either with 0 or 1 or 2. 
			=> [01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.
		- Now we need to do the same for all the three parts and not the 4th part since the 4th part does not need a dot at the end.
			=> ([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\. ..... (1)
		- For the 4th part.Just use the same except without the dot at the end. Also make sure you add a delimiter to know that the string should end after 4 parts.
			==> ([01]?\\d\\d?|2[0-4]\\d|25[0-5])	..... (2)
		- Combine both above (1) and (2),
			==> ([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])

		- Finally we need to add the start of the line and end of the line for the entire address.
			==> ^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$
			where,
				^ start of the line
				$ indicates end of the line.
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;
class IPAddValidation {

	private Pattern pattern;
	private Matcher matcher;

	private String IP_ADDRESS_MATCHER = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
										"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + 
										"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + 
										"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	public static void main(String[] args) {
		IPAddValidation ipvObj = new IPAddValidation();
		ipvObj.initialize();
		ipvObj.validate();
	}

	public void initialize() {
		pattern = Pattern.compile(IP_ADDRESS_MATCHER);
	}

	public void validate() {
		String[] ips = {"1.1.1.1", "255.255.255.255", "192.168.1.1", "10.10.10", "10.0.0.a", "22.2222.22.2"};
		//String[] ips_unmatched = {"10.10.10", "10.0.0.a", "22.2222.22.2"};

		for(String str : ips) {
			if(doValidation(str)) {
				System.out.println(str + "\t\t" + "Valid IP.");
			} else {
				System.out.println(str + "\t\t" + "Not a Valid IP.");
			}
		}
	}

	public boolean doValidation(String ip) {
		matcher = pattern.matcher(ip);
		return matcher.matches();
	}
}