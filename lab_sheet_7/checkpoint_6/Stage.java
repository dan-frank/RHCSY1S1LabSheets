import java.util.HashSet;
import java.util.HashMap;

class LineUp {
	private int stageLimit = 10;
	private Act[] acts = new Act[30];

	LineUp (Act[] acts) {
		this.acts = acts;
	}

	public Act[] getActs() {
		return this.acts;
	}

	public Act getAct(int i) {
		return this.acts[i];
	}

	public void setActs(Act[] acts) {
		this.acts = acts;
	}

	public void setAct(int i, Act act) {
		this.acts[i] = act;
	}

	public void addAct(Act act) {
			String stage = "";

			if (getActs()[getLength() - 1] != null) {
				System.out.println("The LineUp is full!");
				System.out.println("No more can be added.");
			} else {
				for (int i = 0; i < getLength(); i++) {
					if (getActs()[i] == null) {
						if (act.getKind() == "Musical") {
							if (act.getStage() == null) {
								act.setStage("Main");
							}
						} else if (act.getKind() == "Other") {
							if (act.getStage() == null) {
								act.setStage("Variety");
							}
						}

						stage = act.getStage();
						if (freeSlots(stage) <= 0) {
							stage = getNextStage(stage);
						}

						act.setStage(stage);
						System.out.println("There are no more slots for this stage. This act will be moved to " + stage + " stage!");

						setAct(i, act);
						break;
					}
				}
			}
	}

	public int getStageLimit() {
		return this.stageLimit;
	}

	public String getNextStage(String stage) {
		if (stage.equals("Main") && freeSlots("Secondary") > 0) {
			return "Secondary";
		}
		if (stage.equals("Secondary") && freeSlots("Variety") > 0) {
			return "Variety";
		}

		return "Variety";
	}

	public String getNextStageOther(String stage) {
		if (stage.equals("Variety") && freeSlots("Secondary") > 0) {
			return "Secondary";
		}
		if (stage.equals("Secondary") && freeSlots("Main") > 0) {
			return "Main";
		}

		return "Main";
	}

	public int getLength() {
		return this.acts.length;
	}

	public int numberOfActs() {
		for (int i = 0; i < getLength(); i++) {
			if (getActs()[i] == null) {
				return i;
			}
		}
		return getLength();
	}

	public int totalMembers() {
		int total = 0;
		for (int i = 0; i < numberOfActs(); i++) {
			total += getActs()[i].getNumMembers();
		}
		return total;
	}

	public int totalKinds() {
		HashSet<String> kinds = new HashSet<String>(); 
		int total = 0;

		for (int i = 0; i < numberOfActs(); i++) {
			kinds.add(getActs()[i].getKind());
		}

		total = kinds.size();
		return total;
	}

	public int freeSlots(String stage) {
		int total = getStageLimit();

		for (int i = 0; i < numberOfActs(); i++) {
			if (stage.equals(getAct(i).getStage())) {
				total--;
			}
		}

		return total;
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < numberOfActs(); i++) {
			s += getActs()[i] + "\n";
		}
		return s;
	}
}