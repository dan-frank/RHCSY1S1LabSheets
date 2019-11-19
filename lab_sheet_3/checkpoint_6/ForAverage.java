import java.util.Scanner;

class ForAverage {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		double a = 0;

		System.out.println("This program calculates the average of a number with a for loop");

		System.out.print("Enter a number: ");
		n = input.nextInt();

		for (int i = 0; i <= n; i++) {
			a += i;
		}
		a /= n;

		System.out.println("The average of all integers from 0 to " + n + " is: " + a);
	}
}