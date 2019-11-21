class TestLineUp {
	public static void main(String[] args) {
		Act act1 = new Act(5, "Arctic Monkeys", "Musical", "Main");
		Act act2 = new Act(1, "Hobo Johnson", "Musical");
		Act act3 = new Act(1, "Tame Impala", "Musical", "Secondary");
		Act act4 = new Act(1, "Rex Orange County", "Musical");
		Act act5 = new Act(1, "Maggie the Magnificant", "Other");
		Act act6 = new Act(1, "Moorish Martin", "Other", "Main");

		Act[] acts = new Act[30];
		LineUp myFestival = new LineUp(acts);
		myFestival.addAct(act1);
		myFestival.addAct(act2);
		myFestival.addAct(act3);
		myFestival.addAct(act4);
		// for (int i = 0; i < 7; i++) {
		// 	myFestival.addAct(act4);
		// }
		myFestival.addAct(act5);
		myFestival.addAct(act6);
		System.out.println(myFestival);
		System.out.println("There are " + myFestival.totalMembers() + " total members playing at this festival!");
		System.out.println("There are " + myFestival.totalKinds() + " kinds of acts playing at this festival!");
		System.out.println("\"Main\" stage cann add " + myFestival.freeSlots("Main") + " acts");
		System.out.println("\"Secondary\" stage can add " + myFestival.freeSlots("Secondary") + " acts");
		System.out.println("\"Variety\" stage can add " + myFestival.freeSlots("Variety") + " acts");
		System.out.println("Now to remove " + act5.getName());
		myFestival.removeAct(act5);
		System.out.println(myFestival);
	}
}
