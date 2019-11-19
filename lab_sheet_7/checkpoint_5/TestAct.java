class TestAct {
	public static void main(String[] args) {
		Act act1 = new Act(5, "Arctic Monkeys", "Alternative", "BBC Radio 1");
		Act act2 = new Act(1, "Hobo Johnson", "Alternative");
		Act act3 = new Act(1, "Tame Impala", "Hip-Hop", "Main Stage");
		Act act4 = new Act(1, "Rex Orange County", "Alternative", "BBC Radio 2");

		// System.out.println(act1);
		// System.out.println(act2);

		Act[] acts = new Act[30];
		acts[0] = act1;
		acts[1] = act2;
		LineUp myFestival = new LineUp(acts);
		myFestival.addAct(act3);
		myFestival.addAct(act4);
		System.out.println(myFestival);
		System.out.println("There are " + myFestival.totalMembers() + " total memebers playing at this festival!");
		System.out.println("There are " + myFestival.totalKinds() + " total genres playing at this festival!");

		myFestival.addActFill(act4);
	}
}