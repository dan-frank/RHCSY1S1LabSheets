public class StringTest {
    public static void main(String[] args) {
        String str1 = "Pro";
        String str2 = "gram";

        if (str1.equals(str2)) {
            System.out.println("The strings are equal");
        } else if (!str1.equals(str2)) {
            System.out.println("The strings are different");
        }

        System.out.println("Str1 has length " + str1.length());

        String str12 = str1 + str2;
        System.out.println("The concatenation is " + str12);
    }
}