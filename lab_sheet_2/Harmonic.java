class Harmonic {
	public static void main(String[] args) {
		int x = 50000;
		double Hx = 0;
		double HxR = 0;
		double i = 1;

		while (i <= x) {
			Hx += 1 / i;
			i++;
		}

		System.out.print("The Harmonic Series of " + x + " returns " + Hx + "\n");

		while (i > 0) {
			HxR += (1 / i);
			i--;
		}

		System.out.println("The reverse Harmonic Series of " + x + " returns " + HxR + "\n");

		System.out.println("The difference between the two Harmonic series is:");
		System.out.println("H - HR = " + (Hx - HxR));
		System.out.println("HR - H = " + (HxR - Hx) + "\n");

		System.out.println("I believe right to left is more accurate");
		System.out.println("While it uses the same numbers for the calculation the inaccuracy is smaller earlier on, which reduces the uncertainty of the end value");
	}
}
