import java.util.Scanner;

class Palindrome {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int num, // number
			rnum = 0; // reversed number

		System.out.println("This program will reverse an integer and check if it's a palindrome.");
		System.out.print("Enter a number: ");
		num = input.nextInt();

		rnum = reverseNum(num);

        System.out.println("The integer " + num + (num == rnum ? " is " : " isn't ") + "a palindrome!");
	}

	public static int reverseNum(int num) {
		int rnum = 0;

        while(num != 0) {
            int digit = num % 10;
            rnum = rnum * 10 + digit;
            num /= 10;
        }

        return rnum;
	}
}