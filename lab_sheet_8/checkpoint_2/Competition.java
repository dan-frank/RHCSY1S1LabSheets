import java.util.Scanner;

/**
 * Represent an event in the competition.
 */
class Event {
    private String name;
    private int points;

    /**
     * Construct a new event.
     *
     * @param name the name of the event
     * @param points the number of points awarded to the winner
     */
    public Event(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() { return this.name; }
    public int getPoints() { return this.points; }
}

public class Competition {
    // Note: only use one scanner in the whole program
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Event[] events = getEvents();
        int[] scores = getScores(events, 2);
        printScores(scores);
    }

    /**
     * Create the list of events in the competition
     *
     * @return an array of competition events
     */
    private static Event[] getEvents() {
        Event[] events = new Event[6];

        events[0] = new Event("5k Run", 10);
        events[1] = new Event("Long Jump", 5);
        events[2] = new Event("Chess Game", 7);
        events[3] = new Event("Rubik's Cube", 3);
        events[4] = new Event("Victoria Sponge Baking", 10);

        return events;
    }

    /**
     * Prompt the user for the winner of each event
     *
     * @param events the list of competition events
     * @param numPlayers the number of players in the competition
     * @return an array giving the score of each player 0..numPlayers - 1
     */
    private static int[] getScores(Event[] events, int numPlayers) {
        int[] scores = new int[numPlayers];

        for (int i = 0; i < (events.length - 1); i++) {
            int winner = getWinner(events[i], numPlayers);
            scores[winner] += events[i].getPoints();
        }

        return scores;
    }

    /**
     * Prompt the user for the winner of the given event
     *
     * @param event the event in question
     * @param numPlayers the number of players in the competition
     */
    private static int getWinner(Event event, int numPlayers) {
        System.out.println("Which player won the " + event.getName());

        int winner = 0;
        boolean noInput = true;
        while (noInput) {
            System.out.println("Enter player number between 1 and " + numPlayers + ": ");
            if (scanner.hasNextInt()) {
                winner = scanner.nextInt();
            } else {
                scanner.next();
            }

            noInput = winner < 1 || winner > numPlayers;
            if (noInput) {
                System.out.println("You input an incorrect value.");
                System.out.println("Please try again");
            }
        }

        winner = winner - 1;
        return winner;
    }

    /**
     * Print the results of the competition to the screen
     *
     * @param scores an array of scores, one entry for each player
     */
    private static void printScores(int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Player " + (i + 1) + " scored " + scores[i]);
        }
    }
}
