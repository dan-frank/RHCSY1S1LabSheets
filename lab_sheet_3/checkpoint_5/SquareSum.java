import java.util.Scanner;
import java.lang.Math;

class SquareSum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int userInt, squareSum = 0, i = 1;
		
		System.out.println("This system will calculate the square sum of a number");
		System.out.print("Enter a number: ");
		userInt = input.nextInt();

		while (i <= userInt) {
			squareSum += Math.pow(i, 2);
			i++;
		}

		System.out.println("The square sum of " + userInt + " is " + squareSum);
	}
}
