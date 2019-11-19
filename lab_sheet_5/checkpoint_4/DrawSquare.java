import java.util.Scanner;

class DrawSquare {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Size of the square: ");
    int size = scanner.nextInt(),
      i = 0;
    
    String line = "";

    while (i < size) {
      line += "o";
      i++;
    }

    i = 0;

    while (i < size) {
      System.out.println(line);
      i++;
    }
  }
}
