import java.lang.Math;
import java.util.Scanner;

class FillArrayD {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the length of the array: ");
    int arrayLength = scanner.nextInt();

    int [] numbers = new int[arrayLength];

    for (int i = 0; i < arrayLength; i = i + 1) {
      numbers[i] = 1;
    }

    for (int i = (arrayLength - 1); i >= 0; i--) {
      System.out.println("numbers[" + i + "] = " + numbers[i]);
    }
  }
}