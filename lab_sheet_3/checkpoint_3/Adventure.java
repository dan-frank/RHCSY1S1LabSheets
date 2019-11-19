import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Adventure {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean firstRoomReturnable = true,
			eaten_apple = false,
			has_key = false;
		int decision = 0,
			corridorLoop = 2;
		
		String[] message0 = {"0",
							"Welcome to my story.",
							"Enter one of the numbers shown to make decisions.",
							"",
							"----------------------------------------------------------------",
							""};
		String[] message1 = {"3",
							"You wake up in a room.",
							"Ahead of you are two doors.",
							"",
							"What do you do?",
							"1. Enter the door to the left",
							"2. Enter the door to the right",
							"3. Do nothing"};
		String[] message2 = {"2",
							"",
							"Before you stands a long corridor.",
							"",
							"What do you do?",
							"1. Follow the corridor",
							"2. Turn back"};
		String[] message3 = {"2",
							"You walk down the long corridor.",
							"It seems to stretch on forever...",
							"",
							"What do you do?",
							"1. Keep walking",
							"2. Go back"};
		String[] message4 = {"0",
							"",
							"The door is locked.",
							"You use your key to unlock the door and walk through.",
							"The door slams shut behind you with a loud thud.",
							"You hear someone lock the door from other side and take a few steps back before turning around."};
		String[] message5 = {"0",
							"You reach the end of the corridor and find a door.",
							"The door is locked...",
							"You decide to turn back the way you came.",
							"You reach the entrance to the first room.",
							"You enter and close the door behind you."};
		String[] message6 = {"0",
							"",
							"You turn back the way you came and close the door behind you."};
		String[] message7 = {"2",
							"Before you stands a table.",
							"It has three and a half legs, looks like it's barely standing up.",
							"What do you do?",
							"1. Walk over to the table",
							"2. Go back"};
		String[] message8 = {"2",
							"You slowly walk over to the table",
							"As you get close you notice a small box on the table.",
							"What do you do?",
							"1. Open box",
							"2. Go back"};
		String[] message9 = {"0",
							"As you open the box you are blinded by a golden glowing light.",
							"You wait for a few seconds as your eyes ajust to the mysterious light.",
							"Inside the box you find a small key and an apple.",
							"You pocket the key and eat the apple.",
							"You feel rejuvenated.",
							"For the next few minutes you can walk long distances quicker!",
							"You turn around to leave.",
							"As you get to the door you hear a faint voice but can't quite hear what they said.",
							"You call out...",
							"But noone replies.",
							"You leave quickly and close the door behind you."};
		String[] message10 = {"0",
							"A long corridor stretches before you.",
							"You feel full of energy and reach the end in no time!"};
		String[] message11 = {"0",
							"You stand still in shock..."};
		String[] message12 ={"0",
							"",
							"As you turn around the green plains stretch before you forever.",
							"As the sun beams down on your face you collapse in shock at the whole ordeal of this strange room with absolutely none of your questions answered.",
							"",
							"----------------------------------------------------------------",
							"",
							"Thanks for playing my mini Text Adventure!",
							"",
							"Dan :D"};

		printStory(message0);

		while (firstRoomReturnable) {
			
			decision = printStory(message1);
			message1[1] = "";

			if (decision == 1) {
				decision = printStory(message2);

				if (decision == 1) {
					if (!eaten_apple) {
						decision = printStory(message3);

						if (decision == 1) {
							while (corridorLoop > 0) {
								if (decision == 1) {
									decision = printStory(message3);

									corridorLoop--;
								} else if (decision == 2) {
									break;
								}
							}
							
							decision = printStory(message5);
						} else if (decision == 2) {
							decision = printStory(message6);
						}
					} else {
						decision = printStory(message10);

						if (has_key) {
							decision = printStory(message4);
							firstRoomReturnable = false;					
						} else {
							decision = printStory(message5);
						}
					}
				} else if (decision == 2) {
					printStory(message6);
				}
			} else if (decision == 2) {
					decision = printStory(message7);

					if (decision == 1) {
						decision = printStory(message8);

						if (decision == 1) {
							decision = printStory(message9);
							eaten_apple = true;
							has_key = true;
						} else if (decision == 2) {
							decision = printStory(message6);
						}
					} else if (decision == 2) {
						decision = printStory(message6);
					}
			} else if (decision == 3) {
				decision = printStory(message11);
			}
		}

		decision = printStory(message12);
	}

	public static void delayOutput(int sleep) {
		try {
			TimeUnit.MILLISECONDS.sleep(sleep);
		} catch(InterruptedException e) {
			// this part is executed when an exception (in this example InterruptedException) occurs
		}
	}

	public static int printStory(String[] storyArray) {
		int userInput = 0, intLimit, i = 0, sleep = 350;

		intLimit = Integer.parseInt(storyArray[0]);

        for (String storyLine : storyArray) {
        	if (i != 0) {
       			System.out.println(storyLine);
				delayOutput(sleep);
        	}
        	i++;
		}

		if (intLimit > 0) {
			userInput = getUserInput(intLimit, sleep);
			return userInput;
		} else {
			return 0;
		}
    }

    public static int getUserInput(int limit, int sleep) {
		Scanner input = new Scanner(System.in);
		boolean repeatInput = true;
		int userInput = 0;
    	
    	System.out.print("Enter your decision: ");
    	while (repeatInput) {
			userInput = input.nextInt();

			if ((userInput > limit) || (userInput < 1)) {
				System.out.print("Sorry that value is incorrect, please try again: ");
			} else {
				delayOutput(sleep);
				System.out.println();
				repeatInput = false;
			}
		}

		return userInput;
    }
}