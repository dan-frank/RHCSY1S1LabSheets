import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Map;
import java.util.TreeMap;

class Shakespeare {
	public static void main(String[] args) {
		TreeMap<Character, Integer> shakespeare = new TreeMap<Character, Integer>();

		try {
			shakespeare = howManyCharacters();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// printMap(shakespeare);
		printTerminalGraph(shakespeare);
		percentgeOfCharacters(shakespeare);
	}

	public static TreeMap<Character, Integer> howManyCharacters() throws IOException {
		File getFile = new File("shake.txt");
  		BufferedReader readCharacters = new BufferedReader(new FileReader(getFile));

		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		int cId;
		int cCount;

		while ((cId = readCharacters.read()) != -1) {
			cId = Character.toLowerCase(cId);
			char c = (char)cId;

			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				cCount = map.get(c);
				cCount++;
				map.put(c, cCount);
			}
		}

		return map;
	}

	public static void printMap(TreeMap<Character, Integer> map) {
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey();
			int value = entry.getValue();
			System.out.println(key + " : " + value);
		}
	}

	public static void printTerminalGraph(TreeMap<Character, Integer> map) {
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey();
			int value = entry.getValue();

			System.out.print(key + " : ");

			for (int j = 0; j < (value / 1000); j++) {
				System.out.print("*");
			}

			if (value > 0 && value < 1000) {
				System.out.print("*");
			}

			System.out.print(" - " + value);
			System.out.println();
		}
	}

	public static void percentgeOfCharacters(TreeMap<Character, Integer> map) {
		float sum = 0;
		for (float i : map.values()) {
			sum += i;
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey();
			int value = entry.getValue();
			System.out.println(key + " : " + (value / sum) + "%");
		}
	}
}
