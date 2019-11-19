class Act {
	private int num_members;
	private String name;
	private String kind;
	private String stage;
	private boolean fixedStage = false;

	public Act (int num_members, String name, String kind, String stage) {
		this.num_members = num_members;
		this.name = name;
		this.kind = kind;
		this.stage = stage;
		this.fixedStage = true;
	}

	public Act (int num_members, String name, String kind) {
		this.num_members = num_members;
		this.name = name;
		this.kind = kind;
		this.stage = null;
	}

	public int getNumMembers() {
		return this.num_members;
	}

	public void setNumMembers(int num_members) {
		this.num_members = num_members;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKind() {
		return this.kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getStage() {
		return this.stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public boolean getFixedStage() {
		return this.fixedStage;
	}

	@Override
	public String toString() {

		return "--------------------------------" + "\nName: " + getName() + "\nKind: " + getKind() + "\nNumber of Memebers: " + getNumMembers() + "\nStage: " + getStage() + "\nFixed Stage: " + (getFixedStage() ? "Is Fixed" : "Isn't Fixed");
	}
}