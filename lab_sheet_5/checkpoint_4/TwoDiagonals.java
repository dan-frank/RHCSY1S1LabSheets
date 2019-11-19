import java.util.Scanner;

class TwoDiagonals {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Size of the square: ");
    int size = scanner.nextInt();
    boolean diagonal = false;
    
    String line;
   
    for (int i = 0; i < size; i++) {
      line = "";
      for (int j = 0; j < size; j++) {
        if ( ((size - i - 1) == j) || (i == j) ) {
          diagonal = true;
        } else {
          diagonal = false;
        }

        if (diagonal) {
          line += "x";
        } else {
          line += "o";
        }
      }
      System.out.println(line);
    }
  }
}
