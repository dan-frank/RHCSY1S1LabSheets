import java.lang.Math;
import java.util.Scanner;

class FillArrayB {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the length of the array: ");
    int arrayLength = scanner.nextInt();

    double[] numbers = new double[arrayLength];

    for (int i = 0; i < arrayLength; i = i + 1) {
      numbers[i] = getSqrRt(i);
    }

    for (int i = 0; i < arrayLength; i = i + 1) {
      System.out.println("numbers[" + i + "] = " + numbers[i]);
    }
  }

  public static double getSqrRt(int i){
    return Math.sqrt(i);
  }
}