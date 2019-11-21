import java.util.HashSet;

class LineUp {
	Act[] acts = new Act[30];

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
		if (getActs()[getLength() - 1] != null) {
			System.out.println("The LineUp is full!");
			System.out.println("No more can be added.");
		} else {
			for (int i = 0; i < getLength(); i++) {
				if (getActs()[i] == null) {
					setAct(i, act);
					break;
				}
			}
		}
	}

	public void addActFill(Act act) {
		if (getActs()[getLength() - 1] != null) {
			System.out.println("The LineUp is full!");
			System.out.println("No more can be added.");
		} else {
			for (int i = 0; i < getLength(); i++) {
				if (getActs()[i] == null) {
					setAct(i, act);
				}
			}
		}

		System.out.println("The zoo is full!");
	}

	public int getLength() {
		return this.acts.length;
	}

	public int numberOfActs() {
		for (int i = 0; i < getLength(); i++) {
			System.out.println(getAct(i));
			if (getAct(i) == null) {
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

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < numberOfActs(); i++) {
			s += getActs()[i] + "\n";
		}
		return s;
	}
}
