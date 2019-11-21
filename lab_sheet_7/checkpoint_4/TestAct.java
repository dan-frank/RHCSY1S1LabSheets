class TestAct {
	public static void main(String[] args) {
		testActStringStage();
		testActString();	
	}

	public static void testActStringStage() {
		Act act = new Act(5, "Arctic Monkeys", "Alternative/Indie", "BBC Radio 1");
		assert act.toString().equals("--------------------------------" + "\nName: Arctic Monkeys" + "\nGenre: Alternative/Indie" + "\nNumber of Memebers: 5" + "\nStage: BBC Radio 1");
	}

	public static void testActString() {
		Act act = new Act(1, "Hobo Johnson", "Alternative");
		assert act.toString().equals("--------------------------------" + "\nName: Hobo Johnson" + "\nGenre: Alternative" + "\nNumber of Memebers: 1" + "\nStage: null");
	}
}
