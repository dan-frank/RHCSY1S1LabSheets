class TestLineUp {
	public static void main(String[] args) {
		Act act1 = new Act(5, "Arctic Monkeys", "Alternative/Indie", "BBC Radio 1");
		Act act2 = new Act(1, "Hobo Johnson", "Alternative");
		Act act3 = new Act(1, "Tame Impala", "Hip-Hop", "Main Stage");
                Act act4 = new Act(1, "Rex Orange County", "Alternative", "BBC Radio 2");
		
		testActStringStage(act1);
		testActString(act2);	
		
		Act[] acts = new Act[30];
        acts[0] = act1;
        acts[1] = act2;
        LineUp myFestival = new LineUp(acts);
        myFestival.addAct(act3);
        myFestival.addAct(act4);

		testNumberOfActs(myFestival.numberOfActs());
		testTotalMemebers(myFestival.totalMembers());
		testTotalKinds(myFestival.totalKinds());

        myFestival.addActFill(act4);
	}

	public static void testActStringStage(Act act) {
		assert act.toString().equals("--------------------------------" + "\nName: Arctic Monkeys" + "\nGenre: Alternative/Indie" + "\nNumber of Memebers: 5" + "\nStage: BBC Radio 1");
	}

	public static void testActString(Act act) {
		assert act.toString().equals("--------------------------------" + "\nName: Hobo Johnson" + "\nGenre: Alternative" + "\nNumber of Memebers: 1" + "\nStage: null");
	}

	public static void testNumberOfActs(int num) {
		assert num == 4;
	}

	public static void testTotalMemebers(int num) {
		assert num == 8;
	}

	public static void testTotalKinds(int num) {
		assert num == 3;
	}
}
