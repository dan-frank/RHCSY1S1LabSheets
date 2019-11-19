import java.lang.Math;

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
      double longestTrip = 0,
        tempTrip,
        x1, y1, x2, y2;
      int length = points.length;

      for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
          x1 = points[i][0];
          y1 = points[i][1];
          x2 = points[j][0];
          y2 = points[j][1];

          tempTrip = distanceBetween(x1, y1, x2, y2);

          if (tempTrip > longestTrip) {
            longestTrip = tempTrip;
          }
        }
      }

      return longestTrip;
    }

    public static double distanceBetween(double x1, double y1, double x2, double y2) {
      return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    }
}
