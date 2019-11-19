import java.util.Scanner;

class OneDiagonal {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Size of the square: ");
    int size = scanner.nextInt();
    
    String line;
   
    for (int i = 0; i < size; i++) {
      line = "";
      for (int j = 0; j < size; j++) {
        if (i == j) {
          line += "x";
        } else {
          line += "o";
        }
      }
      System.out.println(line);
    }
  }
}
