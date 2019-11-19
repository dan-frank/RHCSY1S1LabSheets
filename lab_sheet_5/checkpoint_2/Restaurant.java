import java.util.Scanner;
import java.util.ArrayList;

class R {
	public static void main(String[] args) {}

	private String name,
		webAddress,
		cuisine;
	
	public R(String name, String webAddress, String cuisine) {
		this.name = name;
		this.webAddress = webAddress;
		this.cuisine = cuisine;
	}

	public String getName(){
		String n = ("Name: " + this.name);
		return n;
	}
}

class Restaurant {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean resDbLoop = true;
		int userChoice;
		ArrayList<R> rl = new ArrayList<R>(); 

		R dominos = new R("Dominos", "www.dominos.co.uk", "Pizza");
		R yosushi = new R("Yo Sushi!", "www.yosushi.co.uk", "Sushi");
		R fiveguys = new R("Five Guys", "www.fiveguys.co.uk", "Burger");

		rl.add(dominos);
		rl.add(yosushi);
		rl.add(fiveguys);

		System.out.println(dominos.getName());
		while (resDbLoop) {
			System.out.println();
			System.out.println("CS1822 Restaurant DB");
			System.out.println("1. Display restaurant list");
			System.out.println("2. Add a restaurant");
			System.out.println("3. Exit");
			System.out.print("Enter a decision: ");
			userChoice = input.nextInt();
			System.out.println();			

			if (userChoice == 1) {
				displayR(rl);
			} else if (userChoice == 2) {
				rl = addR(rl);
			} else if (userChoice == 3) {
				System.out.println("Goodbye!");
				resDbLoop = false;
			} else {
				System.out.println("That is an incorrect value!");
				System.out.println("Please try again...");
			}
		}
	}

	public static void displayR(ArrayList<R> rl) {
		for (int i = 0; i < rl.size(); i++) {
			R tr = rl.get(i);
			System.out.println(tr.getName());
		}
	}

	public static ArrayList<R> addR(ArrayList<R> rl) {
		Scanner input = new Scanner(System.in);
		String name,
			webAddress,
			cuisine;

		System.out.println("Enter the following details to add a restaurant...");
		System.out.print("Enter the restaurants name: ");
		name = input.nextLine();

		System.out.print("Enter the restaurants web address: ");
		webAddress = input.nextLine();

		System.out.print("Enter the restaurants cuisine: ");
		cuisine = input.nextLine();

		R newR = new R(name, webAddress, cuisine);
		rl.add(newR);

		return rl;
	}
}
