import java.util.Scanner;

class Powers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, // Number
			sqrt = 2, // Square Root
			cbrt = 3; // Cube Root
		boolean ps, // Perfect square
			pc; // Perfect Cube

		// Get input
		System.out.println("This program will determine wether a variable is a perfect square or cube integer!");
		System.out.print("Enter a number: ");
		n = input.nextInt();
		System.out.println();

			// Calculate square and cubes
			ps = perfectRoot(n, sqrt);
			pc = perfectRoot(n, cbrt);

			// Result
			System.out.print("The value " + n + " is "); 
			if (!ps && !pc) {
				System.out.print("not a perfect square or cube");
			}

			if (ps) {
				System.out.print("is a perfect square");
			}

			if (ps && pc) {
				System.out.print(" and ");
			}

			if (pc) {
				System.out.print("is a perfect cube");
			}

			System.out.println("!");
	}

	// s = number
	// r = repeat
	private static boolean perfectRoot(int s, int r) {
		boolean isRoot = false;
		int i = 0, // iterator
			a; // accumulator

		while (i <= s) {
			// mutilpies iterator by itself total root times
			a = i;
			for (int j = 1; j < r; j++) {
				a *= i;
			}

			// checks if accumulator == input {input is a root}
			if (a == s) {
				isRoot = true;
			}
			i++;
		}

		return isRoot;
	}
}