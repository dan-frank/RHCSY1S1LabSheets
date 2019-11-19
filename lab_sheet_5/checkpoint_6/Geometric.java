import java.util.Scanner;
import java.util.ArrayList;

class Geometric {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int s, n, r;

		System.out.println("This program calculates the geometric sequence and will need the following values, up starting point (s), point in sequance to calculate to (n), and common ratio (r)");

		System.out.print("What value is s?: ");
		s = input.nextInt();
		System.out.print("What value is n?: ");
		n = input.nextInt();
		System.out.print("What value is r?: ");
		r = input.nextInt();
		System.out.println("geometric(" + n + ") = " + geometric(s, n, r));
	}

	public static ArrayList<Integer> geometric(int s, int n, int r) {
		ArrayList<Integer> g = new ArrayList<Integer>();

		g.add(s);
		for (int i = 0; i < n; i++) {
			s = s * r;

			g.add(s);
		}

		return g;
	}
}