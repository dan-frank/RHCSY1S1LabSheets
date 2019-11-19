import java.util.Scanner;
import java.util.ArrayList;

class Fibonacci {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n, i = 1;
		ArrayList<Integer> f = new ArrayList<Integer>();
		f.add(0);
		f.add(1);
		f.add(1);

		System.out.println("This program calculates the fibonacci sequence up to n");

		System.out.print("What value is n?: ");
		n = input.nextInt();
		System.out.println("fibonacci(" + n + ") = " + fibonacci(n, i, f));
	}

	public static ArrayList<Integer> fibonacci(int n, int i, ArrayList<Integer> f) {
		int fi = 0;

		if (i > 1) {
			fi = f.get(i - 1) + f.get(i);
			f.add(fi);
		}

		if (i <= (n - 2)) {
			i++;
			fibonacci(n, i, f);
		}

		return f;
	}
}