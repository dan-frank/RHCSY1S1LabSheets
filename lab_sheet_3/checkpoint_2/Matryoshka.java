import java.util.Scanner;

class Matryoshka {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean has_golden_token = false,
		        has_key = false;
		int player_input;

		System.out.println("There is a small Russian doll on the table.");
		System.out.println("You open it and find two more dolls, one blue and one green.");

		while (!has_golden_token) {
			if (has_key) {
				System.out.println("There is a blue Russian doll and an open green Russian doll on the table.");
			} else {
				System.out.println("There is a blue Russian doll and a green Russian doll on the table.");
			}
	
			System.out.println("1. Open blue doll");
			if (!has_key) {
				System.out.println("2. Open green doll");
			}
			player_input = input.nextInt();

			if (player_input == 1) {
				System.out.println("The doll contains a small, locked box.");

				if (has_key) {
					System.out.println("Congratulations, you have found the golden token.");
					has_golden_token = true;
				} else {
					System.out.println("You don't have a key to open the box.");
					System.out.println("You put the box back and close the doll.");
				}
			} else if (player_input == 2 && !has_key) {
				System.out.println("The doll contains a small key.");
				System.out.println("You take the key.");
				has_key = true;
			} else {
				System.out.println("That is not a valid input...");
			}
		}

		System.out.println("You have won!");
	}
}