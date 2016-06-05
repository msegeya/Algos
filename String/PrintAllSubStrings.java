class PrintAllSubStrings {
	public static void main(String[] args) {
		String input = "abc";
		printAllSubStrings(input);
	}

	public static void printAllSubStrings(String str) {
		for(int i = 0; i < str.length(); i++) {
			for(int j = 1; j <= str.length() - i; j++) {
				System.out.println(str.substring(i, j + i));
			}
		}
	}
}