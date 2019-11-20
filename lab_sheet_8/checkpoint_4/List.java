class List {
	public static void main(String[] args) {
		LinkNode node1 = new LinkNode("Node 1");
		LinkNode node2 = new LinkNode("Node 2", node1);
		LinkNode node3 = new LinkNode("Node 3", node2);

		System.out.println(node3);
	}
}
