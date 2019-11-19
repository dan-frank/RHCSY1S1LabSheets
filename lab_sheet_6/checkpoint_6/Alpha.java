import java.util.Arrays;

public class Alpha {
    public static void main(String[] args) {
        int[][] h = {{1, 0, 0, 1},
                     {1, 0, 0, 1},
                     {1, 1, 1, 1},
                     {1, 0, 0, 1},
                     {1, 0, 0, 1}};
        int[][] e = {{1, 1, 1, 1},
                     {1, 0, 0, 0},
                     {1, 1, 1, 1},
                     {1, 0, 0, 0},
                     {1, 1, 1, 1}};
        int[][] l = {{1, 0, 0, 0},
                     {1, 0, 0, 0},
                     {1, 0, 0, 0},
                     {1, 0, 0, 0},
                     {1, 1, 1, 1}};
        int[][] o = {{1, 1, 1, 1},
                     {1, 0, 0, 1},
                     {1, 0, 0, 1},
                     {1, 0, 0, 1},
                     {1, 1, 1, 1}};

        printMatrix(h);
        printMatrix(e);
        printMatrix(l);
        printMatrix(l);
        printMatrix(o);

        int[][] cm = concatMatrices(h, e);
        cm = concatMatrices(cm, l);
        cm = concatMatrices(cm, l);
        cm = concatMatrices(cm, o);

        printMatrix(cm);
    }

    private static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 1) {
                    System.out.print("X ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();
    }

    private static int[][] concatMatrices(int[][] m1, int[][] m2) {    
        int length = m1[0].length + m2[0].length + 1;

        int[][] concat = new int[m1.length][length];

        for (int i = 0; i < m1.length; i++) {
            int[] a1 = m1[i];
            int[] a2 = m2[i];

            int pos = 0;

            for (int element : a1) {
                concat[i][pos] = element;
                pos++;
            }
            
            pos++;
            concat[i][pos] = 0;

            for (int element : a2) {
                concat[i][pos] = element;
                pos++;
            }
        }

        return concat;
    }
}
