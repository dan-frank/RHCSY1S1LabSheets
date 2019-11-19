
public class Alpha {
    public static void main(String[] args) {
        // The matrix below defines the letter H
        int[][] h = {{1, 0, 0, 1},
                     {1, 0, 0, 1},
                     {1, 1, 1, 1},
                     {1, 0, 0, 1},
                     {1, 0, 0, 1}};

        // TODO: define similar matrices for E, L, and O.

        // TODO: print out hello:
        // 1) first as a column, using only printMatrix,
        // 2) then as a row, using concatMatrices and then printMatrix
    }

    /**
     * Prints the matrix to the screen row by row.
     *
     * 1 is represented with X all other entries are shown as spaces.
     *
     * @param m a array of arrays of 0 and 1
     */
    private static void printMatrix(int[][] m) {
        // TODO: complete the implementation
    }

    /**
     * Creates a new matrix where each row is the concatenation of the
     * corresponding rows in m1 and m2
     *
     * @param m1 an array of arrays of integers
     * @param m2 an array of arrays of integers with the same number of
     * rows as m1
     * @return the concatenation of m1 and m2
     */
    private static int[][] concatMatrices(int[][] m1, int[][] m2) {
        int[][] concat = new int[m1.length][];

        // TODO: complete the implementation

        return concat;
    }
}
