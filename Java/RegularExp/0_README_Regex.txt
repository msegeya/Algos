************************************************************************************************************************
How to validate IP Address?
Refer: https://examples.javacodegeeks.com/core-java/util/regex/matcher/validate-ip-address-with-java-regular-expression-example/

"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
 "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + 
 "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + 
 "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$"

^ - start of the string
? - optional character
[01]? - optional character but if the character is there then it has be either 0 or 1.
\\d - optional character but if the character is there then it has be a digit.
$ - end of the string. NOTE: end of the string does not have any "."

So why each part has to be divided into 3 parts?
[01]?\\d\\d? - Matches 099 or 199 or 099 or 09 
2[0-4]\\d - 2 is mandatory and next digit should be between [0 to 4] and next digit should be [0 to 9] - 209 or 249
25[0-5]) - 24 is mandatory and next digit should be between [0 to 5] - 250 to 255
************************************************************************************************************************
How to remove consecutive duplicate words in a sentence?
Example:	Goodbye bye bye world world world => Goodbye bye world
			Swapnil went went to to to his business => Swapnil went to his business
			in inthe => in inthe (remains the same. Since the next in is not a word but its part of another word.) 

We can do usign Maps or Sets but .. but the twist in the question is we should only use regular expression to do the same.
We will start small and then make it complex .. :P
1) define word: sequence of character with any number of letters - [a-z A-Z]+
2) In order to compare .. all should be in case insensiteive - ?i
3) mark start of a word and end of the word - \b
4) start doing this for next consecutive words of same type - ?:
5) but how do we know that next consecutive word .. that is the word after 1 or more spaces after current word - \\s+
6) make sure the same word is captured as before - \1
7) make sure it ends there - \b
8) finally repeat this for all words - +

(?i)\\b([a-z]+)\\b(?:\\s+\\1\\b)+

Refer: http://stackoverflow.com/a/23720297/967638

So how do we do it as a program?
String input = "Goodbye bye bye world world world"; // input string
String regex = "(?i)\\b([a-z]+)\\b(?:\\s+\\1\\b)+"; // regular expression
Pattern p = Pattern.compile(regex); // embed the regular expression with the pattern.
Matcher m = p.matches(input); // check whether the pattern matches the expression or not. Only if yes then proceed to replace else not.
if(m.find()) {
	input = input.replaceAll(regex, "$1"); // $1 means for every word of the given input match it with regex and replace it.
}
System.out.println(input); // finally print output.
************************************************************************************************************************
How to check whether a given username is valid or not?
Conditions:
	1) The username can contain alphanumeric characters and/or underscores(_).
	2) The username must start with an alphabetic character.
	3) 8 ≤ |Username_Length| ≤ 30.

We will take each point and construct a regex,
	2) Username must start with alphabetic character - [a-zA-Z]
	1) Username can contain alphanumeric characters and an underscore - [a-zA-Z0-9_]
	3) min length and max length should be 8 and 30 - append the regex with {8, 30}

	Finally, start of a string is identified using ^
			 end of the string is identified using $

	=> "^[a-zA-Z][a-zA-Z0-9_]{7,29}$" --> Why 7 to 29 why not 8 to 30? Since first character is already fixed. So substract 1 from both 8 and 30 => {7, 29}
************************************************************************************************************************