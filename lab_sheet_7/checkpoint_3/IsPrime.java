import java.util.Scanner;

public class IsPrime {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to test for primality: ");
        int num = scanner.nextInt();

        if (isPrime(num))
            System.out.println("The number is prime.");
        else
            System.out.println("The number is not prime.");
    }

    public static boolean isPrime(int num) {
        if (num == 2 || num == 3) {
            return true;
        }

        if ((num <= 1) || (num % 2 == 0) || (num % 3 == 0)) {
            return false;
        }

        int maxFactor = (int) Math.floor(Math.sqrt(num));

        for (int i = 2; i <= (maxFactor / 6); i++) {
            int calc = (int) i * 6;

            if (num % (calc - 1) == 0) {
                return false;
            }
            
            if (num % (calc + 1) == 0) {
                return false;
            }
        }

        return true;
    }
}
