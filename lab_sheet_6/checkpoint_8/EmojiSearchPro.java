import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

class Emoji {
	private String emoji;
	private String name;
	private String category;

	public Emoji (String emoji, String name, String category) {
		this.emoji = emoji;
		this.name = name;
		this.category = category;
	}

	public String getEmoji() {
		return this.emoji;
	}

	public String getName() {
		return this.name;
	}

	public String getCategory() {
		return this.category;
	}
}

class EmojiSearchPro {
	public static String lastEmoji;

	public static void main(String[] args) {
		TreeMap<String, Emoji> emojis = new TreeMap<String, Emoji>();
		ArrayList<String> bookmarks = new ArrayList<String>();

		Scanner in = new Scanner(System.in);

		int choice = 0;

		boolean runProgramme = true;

		try {
			emojis = readEmojiDb();

			while (runProgramme) {
				System.out.println();
				System.out.println("What do you want to do?");
				System.out.println("1. Search for an emoji");
				System.out.println("2. Search for emoji by unicode");
				System.out.println("3. Last emoji");
				System.out.println("4. Search by category");
				System.out.println("5. Exit programme");
				System.out.print("Choose an action: ");
				choice = in.nextInt();
				in.nextLine();
				System.out.println();

				if (choice == 1) {
					bookmarks = emojiSelect(emojis, bookmarks);
					System.out.println("Bookmarks!");
					for (int i = 0; i < bookmarks.size(); i++) {
						System.out.println(bookmarks.get(i));
					}
				} else if (choice == 2) {
					unicodeSearch(emojis, "🏻");
				} else if (choice == 3) {
					System.out.println("Last emoji was: " + lastEmoji);
				} else if (choice == 4) {
					categorySearch(emojis, "smileys and people");
				} else if (choice == 5) {
					System.out.println("Goodbye! 👋");
					runProgramme = false;
				} else {
					System.out.println("Sorry that value is incorrect, please try again... 😅");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static TreeMap<String, Emoji> readEmojiDb() throws IOException {
		File file = new File("emoji-formatted.txt");
  		BufferedReader emojiDb = new BufferedReader(new FileReader(file));

		TreeMap<String, Emoji> map = new TreeMap<String, Emoji>();

		String emojiRow;

		while ((emojiRow = emojiDb.readLine()) != null) {
			String[] emojiRowItems = emojiRow.split(",");

			String emoji = emojiRowItems[0];
			String name = emojiRowItems[1];
			String category = "";
			if (emojiRowItems.length > 2) {
				category = emojiRowItems[2];
			}

			Emoji tEmoji = new Emoji(emoji, name, category);

			map.put(emojiRowItems[1], tEmoji);
		}

		return map;
	}

	public static void printMap(TreeMap<String, Emoji> emojis) {
		for (Map.Entry<String, Emoji> entry : emojis.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue().getEmoji();
			System.out.println(key + " : " + value);
		}
	}

	public static ArrayList<String> emojiSearch(TreeMap<String, Emoji> emojis, String searchTerm) {
		ArrayList<String> results = new ArrayList<String>();

		for (Map.Entry<String, Emoji> entry : emojis.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue().getEmoji();

			if (key.indexOf(searchTerm) >= 0) {
				results.add(value);
			}
		}

		for (int i = 0; i < results.size(); i++) {
			System.out.println((i + 1) + ": " + results.get(i));
		}

		return results;
	}

	public static ArrayList<String> emojiSelect(TreeMap<String, Emoji> emojis, ArrayList<String> bookmarks) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter emoji search term: ");
		String seacrhTerm = in.nextLine();
		System.out.println();

		ArrayList<String> results = emojiSearch(emojis, seacrhTerm);

		boolean runSelect = true;

		int choice;
		int realChoice;

		System.out.println();
		System.out.print("Select an emoji: ");
		choice = in.nextInt();
		in.nextLine();

		if (choice > 0 && choice <= results.size()) {
			realChoice = choice - 1;
			System.out.println("You selected emoji " + results.get(realChoice));
			System.out.println();

			lastEmoji = results.get(realChoice);

			System.out.println("Do you want to bookmark this emoji?");
			System.out.println("1. Yes");
			System.out.println("Anything else. No");
			System.out.print("Choose an action: ");
			choice = in.nextInt();
			in.nextLine();
			System.out.println();

			if (choice == 1) {
				bookmarks.add(results.get(realChoice));
				System.out.println("Added to bookmarks! 👌");
			}
		} else {
			System.out.println("Couldn't find emoji in place " + choice);
		}

		return bookmarks;
	}

	public static ArrayList<String> unicodeSearch(TreeMap<String, Emoji> emojis, String searchTerm) {
		ArrayList<String> results = new ArrayList<String>();

		for (Map.Entry<String, Emoji> entry : emojis.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue().getEmoji();

			if (value.indexOf(searchTerm) >= 0) {
				results.add(value +  " : " + key);
			}
		}

		for (int i = 0; i < results.size(); i++) {
			System.out.println((i + 1) + ": " + results.get(i));
		}

		return results;
	}

	public static ArrayList<String> categorySearch(TreeMap<String, Emoji> emojis, String searchTerm) {
		ArrayList<String> results = new ArrayList<String>();

		for (Map.Entry<String, Emoji> entry : emojis.entrySet()) {
			String key = entry.getKey();
			String category = entry.getValue().getCategory();
			String value = entry.getValue().getEmoji();

			if (category.indexOf(searchTerm) >= 0) {
				results.add(value +  " : " + key);
			}
		}

		for (int i = 0; i < results.size(); i++) {
			System.out.println((i + 1) + ": " + results.get(i));
		}

		return results;
	}
}