public class StringEq {
	public static void main(String[] args) {
		String str1 = "Pro";
		String str2 = str1 + "";

		if (str1 == str2) {
			System.out.println("The strings are equal");
		} else if (str1.equals(str2)) {
			System.out.println("The strings are actually equal");
		}

		System.out.println("We use == to check if both objects point to the same memory location whereas .equals() evaluates to the comparison of values in the objects.");
	}
}