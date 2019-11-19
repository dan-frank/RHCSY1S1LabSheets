import java.util.Scanner;

class Prefix {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean isPrefix = true;
		String input1, // first input
			input2, // second input
			prefix, // smallest string
			line; // largest string
		int length; // length of smallest string

		System.out.println("This programme determines wether one word is the prefix of another.");
		System.out.println("(This programme will remove any accidental whitespace for words entered)");
		System.out.print("Enter the first string: ");
		input1 = input.nextLine();
		System.out.print("Enter the second string: ");
		input2 = input.nextLine();
		System.out.println();

		// removes whitespace from string
		input1 = input1.replaceAll("\\s+","");
		input2 = input2.replaceAll("\\s+","");

		// checks which string is larger and assigns prefix and line
		if (input1.length() < input2.length()) {
			prefix = input1;
			line = input2;
		} else {
			prefix = input2;
			line = input1;
		}

		// checks for 
		length = prefix.length();
		for (int i = 0; i < length; i++) {
			boolean sameChar = (prefix.toLowerCase().charAt(i) == line.toLowerCase().charAt(i));
			if (!sameChar) {
				isPrefix = false;
				break;
			}
		}

		System.out.println("\"" + prefix + "\"" + (isPrefix ? " is " : " is not ") + "a prefix of " + "\"" + line + "\"!");
	}
}