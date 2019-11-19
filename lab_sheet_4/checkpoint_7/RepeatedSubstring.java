import java.util.Scanner;

class RepeatedSubstring {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String line,
			sequance;

		System.out.println("This program calculates how many times a sequance shows up in a given string.");

		System.out.print("Enter a string: ");
		line = input.nextLine();

		substringDistance(line);
	}

	public static void substringDistance(String line) {
		int length = line.length();

		for (int i = 1; i <= (length/2); i++) {
			if (substringCheck(line, i)) {
				System.out.println(line + " has a substring of length " + i);
			}
		}
	}

	public static boolean substringCheck(String line, int dist) {
		int length = line.length();
		for (int i = 0; i+dist < length; i++) {
			// checks if character is the same character at distance check
			if (line.charAt(i) != line.charAt(i+dist)) {
				return false;
			}
		}
		return true;
	}
}