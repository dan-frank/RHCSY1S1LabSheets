import java.util.Scanner;

class Factorial {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		int f = 1;
		int i = 2;

		System.out.println("This program calculates the factorial of n");

		System.out.print("What value is n?: ");
		n = input.nextInt();
		System.out.println("!" + n + " = " + factorial(n));
	}

	public static int factorial(int n) {
		int f = 1;

		for (int i = 2; i <= n; i++) {
			f *= i;
		}

		return f;
	}
}