
public class LongestTrip {

    public static void main(String[] args) {
        // a list of points {x, y}
        int[][] points = {{5, 10},
                          {23, 1},
                          {75, 23},
                          {53, 22},
                          {95, 98},
                          {99, 59},
                          {34, 87},
                          {83, 88},
                          {65, 42},
                          {0, 76}};

        double longestTrip = getLongestTrip(points);

        System.out.println("The longest trip is " + longestTrip);
    }

    /**
     * Finds the longest straight-line distance between two points
     *
     * @param points an array of points, each represented as a length-2
     * array of x and y coord.
     * @return the longest straight-line distance between any two points
     * in points
     */
    public static double getLongestTrip(int[][] points) {
        // TODO: calculate longest distance
    }
}
