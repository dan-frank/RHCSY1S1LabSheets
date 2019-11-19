import java.util.*;
import java.io.*;

class Fiction {
	public static void main(String[] args) throws Exception{
		// gets file
		File storyFile = new File("story.txt"); 
		// reads file
		BufferedReader storyText = new BufferedReader(new FileReader(storyFile));

		// initialises variables
		ArrayList<ArrayList<String>> storyArrayList = new ArrayList<ArrayList<String>>();
		ArrayList<Integer> storyChoices = new ArrayList<Integer>();
		Scanner input = new Scanner(System.in);
		String storyLine;
		boolean gameInPlay = true;
		int userInput = 0, storyIndex = 0, storyMaxOptions = 2;

		// goes through story line by line
		while ((storyLine = storyText.readLine()) != null) {
			// splits line into array
			String[] storyLineArray = storyLine.split(";");

			ArrayList<String> storyLineArrayList = new ArrayList<String>();

			// adds each item in array to array list
			int i = 0;
			for (String storyItem : storyLineArray) {
				storyLineArrayList.add(storyLineArray[i]);
				i++;
			}

			// adds array list to array list array list
			storyArrayList.add(storyLineArrayList);
		}

		// story here
		while (gameInPlay) {
			boolean userInputValid = false;
			int storyArrayListSize = storyArrayList.get(storyIndex).size();
			storyArrayListSize = (storyArrayListSize - 2) / 2;

			while (!userInputValid) {
				System.out.println(storyArrayList.get(storyIndex).get(1));

				if (storyArrayListSize > 0) {
					System.out.print(" Pick up the (1)" + storyArrayList.get(storyIndex).get(2) + " or (2)" + storyArrayList.get(storyIndex).get(4) + "? ");
				}
				userInput = input.nextInt();

				if (userInput <= storyArrayListSize || userInput < 0) {
					userInputValid = true;
				} else {
					System.out.println("Invalid input prodived, please try again");
				}
			}

			storyIndex = userInput;
			storyChoices.add(userInput);

			// check for loop of (size - 2 / 2)
			if (storyChoices.size() >= storyMaxOptions) {
				gameInPlay = false;
			}

			System.out.println();
		}

		if (storyChoices.get(0).equals(1)) {
			if (storyChoices.get(1).equals(1)) {
				System.out.println(storyArrayList.get(3).get(1));
			} else if (storyChoices.get(1).equals(2)) {
				System.out.println(storyArrayList.get(4).get(1));
			}
		} else if (storyChoices.get(0).equals(2)) {
			if (storyChoices.get(1).equals(1)) {
				System.out.println(storyArrayList.get(5).get(1));
			} else if (storyChoices.get(1).equals(2)) {
				System.out.println(storyArrayList.get(6).get(1));
			}
		}
	}
}

// [
	// [1, Pick up the banana or the apple?,  Banana,  2,  Apple,  3],
	// [2, Pick up the milk or the pancake batter?,  Milk,  4,  Batter,  5],
	// [3, Pick up the pastry or the toffee?,  Pastry,  6,  Toffee,  7],
	// [4, You have made banana milkshake!],
	// [5,  You have made banana pancakes!],
	// [6,  You have made apple pie!],
	// [7,  You have made a toffee apple!]
// ]