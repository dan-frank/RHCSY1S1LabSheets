class Integers {
	public static void main(String[] args) {
		System.out.println("This program will do a couple things:");
		System.out.println("1. Print out the positive even integers that are strictly less than 20");
		System.out.println("2. Print out the positive odd integers that are lesser or equal than 21");
		System.out.println("3. Print out the positive multiples of 5 that are lesser or equal than 100");
		System.out.println("4. Print out the first 20 positive integers in reverse order from the greatest to the smallest");
		System.out.println();

		System.out.println("Positive even integers that are strictly less than 20");
		for (int i = 1; i < 20; i++) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println("\n");

		System.out.println("Positive odd integers that are lesser or equal than 21");
		for (int i = 1; i <= 21; i++) {
			if (i % 2 != 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println("\n");

		System.out.println("Positive multiples of 5 that are lesser or equal than 100");
		for (int i = 1; i <= 100; i++) {
			if (i % 5 == 0) {
				System.out.print(i + " ");
			}
		}
		System.out.println("\n");

		System.out.println("First 20 positive integers in reverse order from the greatest to the smallest");
		for (int i = 20; i > 0; i--) {
				System.out.print(i + " ");
		}
		System.out.println("\n");

	}
}