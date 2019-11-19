import java.util.Scanner;

class Power {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double a, ap = 0;
		int n, i = 0;

		System.out.println("This program will calculate the power of two values without using Math.pow");
		System.out.print("Enter a number: ");
		a = input.nextDouble();
		System.out.print("Enter a power: ");
		n = input.nextInt();		

		if (n == 0) {
			ap = 0;
		} else if (n > 0) {
			i = 1;
			ap = a;

			while (i < n) {
				ap *= a;
				i++; 
			}
		} else if (n < 0) {
			i = 0;
			ap = 1;

			while (i > n) {
				ap /= a;
				i--;
			}
		}

		System.out.println("The result of " + a + "^" + n + " without Math.pow is: " + ap);
	}
}
