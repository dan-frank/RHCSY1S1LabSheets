import java.util.HashSet;
import java.util.HashMap;

class LineUp {
	private int stageLimit = 10;
	private Act[] acts = new Act[30];

	LineUp (Act[] acts) {
		this.acts = acts;
	}

	public Act[] getActs() { return this.acts; }

	public Act getAct(int i) { return this.acts[i]; }

	public void setActs(Act[] acts) { this.acts = acts; }

	public void setAct(int i, Act act) { this.acts[i] = act; }

	public void addAct(Act act) {
		if (getAct(getLength() - 1) != null) {
			System.out.println("The LineUp is full!");
			System.out.println("No more can be added.");
		} else {
			int iterator = numberOfActs();

			if (getAct(iterator) == null) {
				if (act.getStage() == null) {
					act.setStage((act.getKind().equals("Musical") ? "Main" : "Variety"));
				}

				if (freeSlots(act.getStage()) <= 0) {
					if (act.getFixedStage()) {
						Act moveAct = findFirstActFromStage(act.getStage());
						moveAct.setStage(getNextStage(moveAct));
					} else {
						act.setStage(getNextStage(act));
					}
				}

				setAct(iterator, act);
			}
		}
	}

	public int getStageLimit() { return this.stageLimit; }

	public String getNextStage(Act act) {
		boolean foundStage = false;
		String stage = "Variety";

		while (!foundStage) {
			if (act.getKind().equals("Musical")) {
				if (act.getStage().equals("Main")) {
					act.setStage("Secondary");
				} else if (act.getStage().equals("Secondary")) {
					act.setStage("Variety");
				} else if (act.getStage().equals("Variety")) {
					act.setStage("Main");
				}
			} else {
				if (act.getStage().equals("Variety")) {
					act.setStage("Secondary");
				} else if (act.getStage().equals("Secondary")) {
					act.setStage("Main");
				} else if (act.getStage().equals("Main")) {
					act.setStage("Variety");
				}
			}

			if (freeSlots(act.getStage()) >= 0) {
				foundStage = true;
			}
		}

		return stage;
	}

	public int getLength() { return this.acts.length; }

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

	public Act findFirstActFromStage(String stage) {
		for (int i = 0; i < numberOfActs(); i++) {
			if (getAct(i).getStage().equals(stage)) {
				return getAct(i);
			}
		}

		return getAct(0);
	}

	public void removeAct(Act act) {
		int pos = 0;
		// find act in array
		for (pos = 0; pos < numberOfActs(); pos++) {
			if (act == getAct(pos)) {
				break;
			}
		}
		// removes act by replacing them in list and moving everyone else down
		for (pos = pos; pos < numberOfActs(); pos++) {
			setAct(pos, getAct(pos + 1));
		}
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