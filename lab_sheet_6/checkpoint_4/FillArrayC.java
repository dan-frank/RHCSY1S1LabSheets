import java.lang.Math;
import java.util.Scanner;

class FillArrayC {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the length of the array: ");
    int arrayLength = scanner.nextInt();

    int [] numbers = new int[arrayLength];

    for (int i = 0; i < arrayLength; i = i + 1) {
      numbers[i] = isEven(i);
    }

    for (int i = 0; i < arrayLength; i = i + 1) {
      System.out.println("numbers[" + i + "] = " + numbers[i]);
    }
  }

  public static int isEven(int i){
    return ((i % 2 == 0) ? 0 : 1);
  }
}