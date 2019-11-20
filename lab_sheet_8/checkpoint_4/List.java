class List {
	public static void main(String[] args) {
		int upperBound = 4;

		LinkNode node = null;
		LinkNode prev = null;
		for (int i = 0; i < upperBound; i++) {
			node = new LinkNode("Node " + i, prev);
			prev = node;
		}
		System.out.println(node);
	}
}
