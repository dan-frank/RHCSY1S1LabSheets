import java.util.Scanner;

class DrawSquare {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Size of the square: ");
    int size = scanner.nextInt();
    
    String line = "";
   
    for (int i = 0; i < size; i++) {
      line += "o";
    }
    
    for (int i = 0; i < size; i++) {
      System.out.println(line);
    }
  }
}
