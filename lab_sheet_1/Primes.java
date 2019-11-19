public class Primes {
	public static void main(String[] args) {
		
		int upperBound = 56;
		int[] grid = new int[upperBound];

		int num;
		int multiple;

		for (num = 2; num < upperBound; num++) {
			if (grid[num] == 0) {
				for (multiple = 2 * num; multiple < upperBound; multiple = multiple + num) {
					grid[multiple] = 1;

					System.out.println(multiple);
				}
			}

			if (grid[num] == 0) {
				// System.out.println(num);
			}
		}

	}
}