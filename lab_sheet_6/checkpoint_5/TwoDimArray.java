import java.util.Scanner;
import java.util.Arrays;

class TwoDimArray {
  public static void main(String[] args) {
    // the dimensions of the array
    int height = 3, width = 4;

    // the array
    String[][] array = new String[height][width];
    
    // an auxiliary variable to print the array
    String line;
    
    // fill the 2-dim array
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        array[i][j] = " "+ i + j;
      }
    }
    
    // print the 2-dim array
    for (int i = 0; i < height; i++) {
      line = "";
      for (int j = 0; j < width; j++) {
        line += array[i][j];
      }
      System.out.println(line);
    }

    Scanner in = new Scanner(System.in);
    int row = 0;
    int column = 0;
    boolean goodInput = false;

    while (!goodInput) {
      System.out.print("Enter row number: ");
      row = in.nextInt();

      if (row < 1 || row > (height + 1)) {
        System.out.println("This value is out of bounds of the 2D array");
      } else {
        goodInput = true;
        row -= 1;
      }
    }

    for (int i = 0; i < width; i++) {
      System.out.print(array[row][i]);
    }
    System.out.println();

    goodInput = false;

    while (!goodInput) {
      System.out.print("Enter column number: ");
      column = in.nextInt();

      if (column < 1 || column > (width + 1)) {
        System.out.println("This value is out of bounds of the 2D array");
      } else {
        goodInput = true;
        column -= 1;
      }
    }

    for (int i = 0; i < height; i++) {
      System.out.println(array[i][column]);
    }
  }
}
