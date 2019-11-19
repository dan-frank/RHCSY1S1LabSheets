import java.util.Scanner;

class EvenLength {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String userInput;
		int strLength;

		System.out.println("Calculate why a strings ");
		System.out.print("Enter a string: ");
		userInput = input.nextLine();
		strLength = userInput.length();

		System.out.print("The string is " + strLength + " characters long and is ");
		if (strLength % 2 == 0) {
			System.out.println("even");
		} else {
			System.out.println("odd");
		}
	}
}