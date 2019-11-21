class TreeNode {
	private String payload;
	private TreeNode left;
	private TreeNode right;

	public TreeNode(String payload) {
		this.payload = payload;
		this.left = null;
		this.right = null;
	}

	public TreeNode(String payload, TreeNode left, TreeNode right) {
		this.payload = payload;
		this.left = left;
		this.right = right;
	}

	public String getPayload() { return this.payload; }
	public TreeNode getNextLeft() { return this.left; }
	public TreeNode getNextRight() { return this.right; }

	public String printLeft() {
		String s = "";
		
		s += getPayload();

		if (getNextLeft() != null) {
			s += "\n" + getNextLeft();
		}

		return s;
	}

	public String printRight() {
		String s = "";

		s += getPayload();

		if (getNextRight() != null) {
			s += "\n" + getNextRight();
		}
		
		return s;
	}

	@Override
	public String toString() {
		return getPayload();
	}

	public static void main(String[] args) {
		TreeNode leaf1 = new TreeNode("Leaf 1");
		TreeNode leaf2 = new TreeNode("Leaf 2");
		TreeNode leaf3 = new TreeNode("Leaf 3");
		TreeNode leaf4 = new TreeNode("Leaf 4");
		
		TreeNode internal1 = new TreeNode("Internal 1", leaf1, leaf2);
		TreeNode internal2 = new TreeNode("Internal 2", leaf3, leaf4);

		TreeNode root = new TreeNode("root", internal1, internal2);

		System.out.println(root.printLeft());
		System.out.println(root.printRight());
	}
}
