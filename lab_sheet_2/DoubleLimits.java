class DoubleLimits {
	public static void main(String[] args) {
		double x = 0.2;
		double y = 0.1;
		double z = x - y;

		double x2 = 0.3;
		double y2 = 0.2;
		double z2 = x2 - y2;

		System.out.println(x + " - " + y + " = " + z);
		System.out.println(x2 + " - " + y2 + " = " + z2);

		System.out.println("This is because 0.1, 0.2, and 0.3 have (infinite) recurring representations in binary, in the just the same way that the fraction 1/3 has a recurring representation in decimal (i.e. 0.33333...). Thus, the computer can only approximate these values. The result, using these approximations, is that evaluating 0.3 - 0.2 has a value slightly smaller than 0.1, and 0.2 - 0.1 has a value slightly larger than 0.1.");
	}
}