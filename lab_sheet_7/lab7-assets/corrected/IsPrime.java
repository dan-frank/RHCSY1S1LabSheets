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
        if (num <= 1)
            return false;

        int maxFactor = (int) Math.floor(Math.sqrt(num));

        for (int i = 2; i <= maxFactor; i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }
}
