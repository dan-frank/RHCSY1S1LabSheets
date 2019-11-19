import java.util.Scanner;

class Dessert {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String choice = "",
		       choice1 = "",
		       choice2 = "";
		boolean firstChoice = false,
		        secondChoice = false;

		while(!firstChoice) {
			System.out.print("Pick up the banana or apple? ");
			choice1 = input.nextLine();

			if (choice1.equals("banana")) {
				firstChoice = true;

				while (!secondChoice) {
					System.out.print("Pick up the milk or pancake batter? ");
					choice2 = input.nextLine();

					if (choice2.equals("milk")) {
						secondChoice = true;
						choice = "banana milkshake";
					} else if (choice2.equals("pancakes")) {
						secondChoice = true;
						choice = "banana pancakes";
					} else {
						System.out.println("That is not a valid option, please try again");
					}
				}
				

			} else if (choice1.equals("apple")) {
				firstChoice = true;


				while (!secondChoice) {
					System.out.print("Pick up the pastry or the toffee? ");
					choice2 = input.nextLine();

					if (choice2.equals("pastry")) {
						secondChoice = true;
						choice = "apple pie";
					} else if (choice2.equals("toffee")) {
						secondChoice = true;
						choice = "a toffee apple";
					} else {
						System.out.println("That is not a valid option, please try again");
					}
				}

			} else {
				System.out.println("That is not a valid option, please try again");
			}
		}

		if (!choice.equals("")) {
			System.out.println("You have made " + choice + "!");			
		} else {
			System.out.println("A dessert was not set!");
			System.out.println("Please try again...");
		}
	}
}
