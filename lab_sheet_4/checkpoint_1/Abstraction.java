import java.lang.Math;

class Abstraction {
	public static void main(String[] args) {
		// ( -b +- sqrt(b^2-4ac^2) ) / 2a
		double a = 2,
			b = 3,
			c = -5,
			x1 = 0,
			x2 = 0;

		System.out.println("The program calculates the quadratic formula.");

		x1 = ((b*-1) - Math.sqrt(discriminant(a,b,c)))/(a*a);
		x2 = ((b*-1) + Math.sqrt(discriminant(a,b,c)))/(a*a);
		
		System.out.println("The quadratic formula x="+a+"x^2+"+b+"x+"+c+" results in...");
		System.out.println("x1 = " + x1);
		System.out.println("x2 = " + x2);
	}

	private static double discriminant(double a, double b, double c) {
		double disc;

		b = b*b;
		disc = b - (4 * a * c);

		return disc;
	}
}