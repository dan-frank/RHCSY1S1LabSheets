import java.util.Scanner;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import java.util.Collections;
import java.util.Comparator;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.io.Writer;
import java.io.PrintWriter;

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

	public String getName() {
		return this.name;
	}

	public void editName(String name) {
		this.name = name;
	}

	public String getWebAddress() {
		return this.webAddress;
	}

	public void editWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public String getCuisine() {
		return this.cuisine;
	}

	public void editCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
}

class Restaurant {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean resDbLoop = true;
		int userChoice;
		HashMap<String, ArrayList<R>> s = new HashMap<String, ArrayList<R>>();

		try {
			s = readDB(s);			
		} catch (Exception e) {
			e.printStackTrace();
		}

		while (resDbLoop) {
			System.out.println();
			System.out.println("CS1822 Restaurant DB");
			System.out.println("1. Display restaurant list");
			System.out.println("2. Display restaurant list A - Z");
			System.out.println("3. Get a recommendation");
			System.out.println("4. Add a restaurant");
			System.out.println("5. Edit a restaurant in DB");
			System.out.println("6. Delete a restaurant from DB");
			System.out.println("7. Open a restaurants web address");
			System.out.println("8. Exit");
			System.out.print("Enter a decision: ");
			userChoice = input.nextInt();
			System.out.println();

			if (userChoice == 1) {
				displayR(s);
			} else if (userChoice == 2) {
				displayRAZ(s);
			} else if (userChoice == 3) {
				suggest(s);
			} else if (userChoice == 4) {
				s = addR(s);
			} else if (userChoice == 5) {
				s = editR(s);
			} else if (userChoice == 6) {
				s = delR(s);
			} else if (userChoice == 7) {
				openRUrl(s);
			} else if (userChoice == 8) {
				System.out.println("Goodbye!");
				resDbLoop = false;
			} else {
				System.out.println("That is an incorrect value!");
				System.out.println("Please try again...");
			}
		}
	}

	public static HashMap<String, ArrayList<R>> readDB(HashMap<String, ArrayList<R>> s) throws Exception {
		File dbTxt = new File("restaurantDB.txt");
		BufferedReader db = new BufferedReader(new FileReader(dbTxt));
		String row;

		while ((row = db.readLine()) != null) {
			String[] rowArray = row.split(",");

			R r = new R(rowArray[0], rowArray[1], rowArray[2]);
			s = updateS(s, r);
		}

		return s;
	}

	public static void updateDB(HashMap<String, ArrayList<R>> s) throws Exception {
		File dbTxt = new File("restaurantDB.txt");
		dbTxt.delete();

		PrintWriter writer = new PrintWriter("restaurantDB.txt", "UTF-8");

		for (Map.Entry<String, ArrayList<R>> si : s.entrySet()) {
			ArrayList<R> rl = si.getValue();
			for (int i = 0; i < rl.size(); i++) {
				R r = rl.get(i);
				writer.println(r.getName() + "," + r.getWebAddress() + "," + r.getCuisine());
			}
		}
		writer.close();
	}

	public static void displayR(HashMap<String, ArrayList<R>> s) {
		for (Map.Entry<String, ArrayList<R>> si : s.entrySet()) {
			ArrayList<R> rl = si.getValue();
			for (int i = 0; i < rl.size(); i++) {
				R r = rl.get(i);
				System.out.println("| Name: " + r.getName() + " | Cuisine: " + r.getCuisine() + " | Web Address: " + r.getWebAddress() + " |");
			}
		}
	}

	public static void displayRAZ(HashMap<String, ArrayList<R>> s) {
		ArrayList<R> rlaz = new ArrayList<R>();

		for (Map.Entry<String, ArrayList<R>> si : s.entrySet()) {
			ArrayList<R> rl = si.getValue();
			for (int i = 0; i < rl.size(); i++) {
				R r = rl.get(i);
				rlaz.add(r);
			}
		}

		Collections.sort(rlaz, new Comparator<R>() {
			@Override
			public int compare(R s1, R s2) {
				return s1.getName().compareToIgnoreCase(s2.getName());
			}
		});

		for (int i = 0; i < rlaz.size(); i++) {
			R r = rlaz.get(i);
			System.out.println("| Name: " + r.getName() + " | Cuisine: " + r.getCuisine() + " | Web Address: " + r.getWebAddress() + " |");
		}
	}

	public static HashMap<String, ArrayList<R>> addR(HashMap<String, ArrayList<R>> s) {
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
		s = updateS(s, newR);

		return s;
	}

	public static R callR(HashMap<String, ArrayList<R>> s) {
		Scanner input = new Scanner(System.in);
		String ui;
		boolean callLoop = true;

		R ar = new R("", "", "");

		while (callLoop) {
			System.out.print("Enter the name of a restaurant to find: ");
			ui = input.nextLine();

			// finds class object in 
			for (Map.Entry<String, ArrayList<R>> si : s.entrySet()) {
				ArrayList<R> rl = si.getValue();
				for (int i = 0; i < rl.size(); i++) {
					R r = rl.get(i);

					if (r.getName().equals(ui)) {
						ar = r;
					}
				}
			}

			if (ar.getName().equals("")) {
				System.out.println("Could not find an the restaurant with the name " + ui);
				System.out.println("Please try again...");
			} else {
				callLoop = false;
			}
		}

		return ar;
	}

	public static HashMap<String, ArrayList<R>> editR(HashMap<String, ArrayList<R>> s) {
		Scanner input = new Scanner(System.in);
		boolean editing = true;
		int ui;
		String us;

		R fr = callR(s);

		while (editing) {
			System.out.println();
			System.out.println("What would you like to do?");
			System.out.println("1. Edit name");
			System.out.println("2. Edit web address");
			System.out.println("3. Edit cuisine");
			System.out.println("4. Finish editing");
			System.out.print("Enter a number: ");
			ui = input.nextInt();
			input.nextLine();

			System.out.println();

			if (ui == 1) {
				System.out.print("Enter the new name: ");
				us = input.nextLine();
				fr.editName(us);
				System.out.println("This restaurants new name is " + fr.getName() );
			} else if (ui == 2) {
				System.out.print("Enter the new web address: ");
				us = input.nextLine();
				fr.editWebAddress(us);
				System.out.println("This restaurants new web address is " + fr.getWebAddress() );
			} else if (ui == 3) {
				System.out.print("Enter the new cuisine: ");
				us = input.nextLine();

				// edit 's' first
				String key = fr.getCuisine();
				ArrayList<R> rl = s.get(key);

				// remove from map
				rl.remove(fr);
				s.put(key, rl);

				if (rl.isEmpty()) {
					s.remove(key);
				}

				fr.editCuisine(us);
				System.out.println("This restaurants new cuisine is " + fr.getCuisine() );
			} else if (ui == 4) {
				editing = false;
			} else {
				System.out.println("Sorry that's not a valid input!");
				System.out.println("Please try again...");
			}
		}

		s = updateS(s, fr);
		return s;
	}

	public static HashMap<String, ArrayList<R>> delR(HashMap<String, ArrayList<R>> s) {
		Scanner input = new Scanner(System.in);
		int ui;
		String key;

		System.out.println("Are you sure you want to delete? (1. Yes, 2. No)");
		ui = input.nextInt();
		input.nextLine();

		if (ui == 1) {
			// get object
			R fr = callR(s);
			key = fr.getCuisine();
			ArrayList<R> rl = s.get(key);

			// remove from map
			rl.remove(fr);
			s.put(key, rl);

			// checks if map is empty
			if (rl.isEmpty()) {
				s.remove(key);
			}
		}

		return s;
	}

	public static HashMap<String, ArrayList<R>> updateS(HashMap<String, ArrayList<R>> s, R r) {
		String key = r.getCuisine();

		if (!s.containsKey(key)) {
			s.put(key, new ArrayList<R>());
		}
		s.get(key).add(r);

		try {
			updateDB(s);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return s;
	}

	public static void suggest(Map<String, ArrayList<R>> s) {
		Scanner input = new Scanner(System.in);
		String sIn;

		System.out.print("Enter a type of cuisine: ");
		sIn = input.nextLine();

		System.out.println();

		if (s.containsKey(sIn)) {
			ArrayList<R> rl = s.get(sIn);
			System.out.println("We suggest...");
			System.out.println();
			for (int i = 0; i < rl.size(); i++) {
				R r = rl.get(i);
				System.out.println("| Name: " + r.getName() + " | Cuisine: " + r.getCuisine() + " | Web Address: " + r.getWebAddress() + " |");
			}
		} else {
			System.out.println("Sorry, there are no restaurants matching your request...");
		}
	}

	public static void openRUrl(HashMap<String, ArrayList<R>> s) {
		R r = callR(s);

		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;

		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			try {
				URI uri = new URI(r.getWebAddress());
				desktop.browse(uri);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
