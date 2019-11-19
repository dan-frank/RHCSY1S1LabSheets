import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Scanner;

import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

class EmojiSearch {
	public static void main(String[] args) {
		TreeMap<String, String> emojis = new TreeMap<String, String>();

		Scanner in = new Scanner(System.in);
		String seacrhTerm;

		try {
			emojis = readEmojiDb();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// printMap(emojis);
		System.out.print("Enter emoji search term: ");
		seacrhTerm = in.nextLine();
		
		emojiSearch(emojis, seacrhTerm);
	}

	public static TreeMap<String, String> readEmojiDb() throws IOException {
		File file = new File("emoji-formatted.txt");
  		BufferedReader emojiDb = new BufferedReader(new FileReader(file));

		TreeMap<String, String> map = new TreeMap<String, String>();

		String emojiRow;

		while ((emojiRow = emojiDb.readLine()) != null) {
			String[] emojiRowItems = emojiRow.split(",");

			map.put(emojiRowItems[1], emojiRowItems[0]);
		}

		return map;
	}

	public static void printMap(TreeMap<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			System.out.println(key + " : " + value);
		}
	}

	public static void emojiSearch(TreeMap<String, String> map, String searchTerm) {
		ArrayList<String> results = new ArrayList<String>();

		for (Map.Entry<String, String> entry : map.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();

			if (key.indexOf(searchTerm) >= 0) {
				results.add(value);
			}
		}

		for (int i = 0; i < results.size(); i++) {
			System.out.print(results.get(i) + ((i == results.size() - 1) ? "" : ", "));
		}
	}
}