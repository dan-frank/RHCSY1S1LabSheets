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
  }
}
