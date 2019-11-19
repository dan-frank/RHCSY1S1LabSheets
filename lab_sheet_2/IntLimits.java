class IntLimits {
	public static void main(String[] args) {
		int x = 2147483646;
		int y = x + 3;

		System.out.println("The output of x (" + x + ") and y (x + 3) is " + y);

		x = -2147483646;
		y = x - 5;

		System.out.println("The output of x (" + x + ") and y (x - 5) is " + y + "\n\n");

		int maxInt = Integer.MAX_VALUE;
		int minInt = Integer.MIN_VALUE;

		System.out.println("When something exceeds the data type's max value (in Java, being " + maxInt + "), it loops back to its min value. And when it is less than the min value, it loops back to the max value.");
		System.out.println("If we ignored the max value the result would be 2147483648. But since that is one larger than the max value it loops back to the min value again, which is " + minInt + "\n\n");



		System.out.println("This behaviour is because of how Java handles data.");
		System.out.println("Java follows a rule called Two's Company.");
		System.out.println("An int in Java is 32 bits big which translates to -2,147,483,648 to 2,147,483,647.");
		System.out.println("Binary stores data as 1's and 0's.");
		System.out.println("For a 32bit data type like integer, each int will be stored in binary as");
		System.out.println("0000 0000 0000 0000 0000 0000 0000 0000\n\n");

		System.out.println("We will handle a 4bit binary value to explain how Two's Company works (0000)");
		System.out.println("From right to left, each 0 or 1 will represent a number.");
		System.out.println("The first bit will represent 1 the second integer 2, the third 4, the fourth 8.");
		System.out.println("However following Two's Company the last bit will represent whether the number is a positive or negative number. For example...");
		System.out.println("0111 => 7");
		System.out.println("1111 => -7");
		System.out.println("While this makes sense it can lead to some interesting results when adding following this rule.\n\n");

		System.out.println("If you take 6 (0110) and -1 (1001) for example, you would expect to get 5. However when adding in binary you get...");
		System.out.println("0110");
		System.out.println("1001");
		System.out.println("----");
		System.out.println("1111");
		System.out.println("Which translates to -7.");
		System.out.println("Another example would be 5 (0101) and -5 (1101) you would expect to get 0, however...");
		System.out.println("  0101");
		System.out.println("  1101");
		System.out.println("------");
		System.out.println("1 0010");
		System.out.println("The last digit (first on the left) is larger than 4 bits and is therefore ignored but we're left with 0010 in binary which actually results in the value 2.\n\n\n\n");

		long xL = 2147483646;
		long yL = xL + 3;

		System.out.println("The output of x (" + xL + ") and y (x + 3) is " + yL);

		xL = -2147483646;
		yL = xL - 5;

		long maxLong = Long.MAX_VALUE;
		long minLong = Long.MIN_VALUE;

		System.out.println("The output of x (" + xL + ") and y (x - 5) is " + yL + "\n\n");

		System.out.println("If we change the value from an int to a long then we don't have this problem.");
		System.out.println("We will eventually but not until much larger values.\n");
		System.out.println("The largest value for a long being " + maxLong);
		System.out.println("The smallest value for a long being " + minLong);
	}
}
