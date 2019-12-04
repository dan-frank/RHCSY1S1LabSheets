class Node {
	private String payload;
	private Node next;

	public Node (String payload) {
		this.payload = payload;
		this.next = null;
	}

	public Node (String payload, Node next) {
		this.payload = payload;
		this.next = next;
	}

	public String getPayload() { return this.payload; }
	public Node getNext() { return this.next; }

	@Override
	public String toString() {
		if (getNext() != null) {
			return getPayload() + "\n" + getNext();
		}
		
		return getPayload();
	}

	public static void main(String[] args) {
		int upperBound = 4;

                Node node = null;
                Node prev = null;
                for (int i = 0; i < upperBound; i++) {
                        node = new Node("Node " + i, prev);
                        prev = node;
                }
                System.out.println(node);
	}
}
