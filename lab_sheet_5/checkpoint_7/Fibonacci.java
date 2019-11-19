import java.util.Scanner;
import java.util.ArrayList;

class Fibonacci {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;

		System.out.println("This program calculates the fibonacci sequence up to n");

		System.out.print("What value is n?: ");
		n = input.nextInt();
		System.out.println("fibonacci(" + n + ") = " + fibonacci(n));
	}

	public static ArrayList<Integer> fibonacci(int n) {
		int fi = 0, t1 = 1, t2 = 0;
		ArrayList<Integer> f = new ArrayList<Integer>();

		f.add(fi);
		for (int i = 0; i < n; i++) {
			t2 = fi;
			fi = fi + t1;
			t1 = t2;

			f.add(fi);
		}

		return f;
	}
}