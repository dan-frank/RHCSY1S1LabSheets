class TestAct {
	public static void main(String[] args) {
		Act act1 = new Act(5, "Arctic Monkeys", "Musical", "Main");
		Act act2 = new Act(1, "Hobo Johnson", "Musical");
		Act act3 = new Act(1, "Tame Impala", "Musical", "Secondary");
		Act act4 = new Act(1, "Rex Orange County", "Musical");
		Act act5 = new Act(1, "Maggie the Magnificant", "Other");

		Act[] acts = new Act[30];
		LineUp myFestival = new LineUp(acts);
		myFestival.addAct(act1);
		myFestival.addAct(act2);
		myFestival.addAct(act3);
		myFestival.addAct(act4);
		myFestival.addAct(act5);
		System.out.println(myFestival);
		System.out.println("There are " + myFestival.totalMembers() + " total memebers playing at this festival!");
		System.out.println("There are " + myFestival.totalKinds() + " total genres playing at this festival!");
		System.out.println("\"Main\" stage cann add " + myFestival.freeSlots("Main") + " acts");
		System.out.println("\"Secondary\" stage can add " + myFestival.freeSlots("Secondary") + " acts");
		System.out.println("\"Variety\" stage can add " + myFestival.freeSlots("Variety") + " acts");
	}
}