class LinkedList {
	private LinkNode head;
	
	public LinkedList() {
		this.head = null;
	}
	
	public LinkNode getHead() { return this.head; }
	public void setHead(LinkNode head) { this.head = head; }
	
	public void addHead(String value) {
		LinkNode newNode = new LinkNode(value, this.head);
		setHead(newNode);
	}

	public void removeHead() {
		setHead(this.head.getNext());
	}
	
	@Override
	public String toString() {
		return "" + this.head;
	}
	
	public static void main(String[] args) {
		int upperBound = 4;
		
		LinkNode node = null;
		LinkedList head = new LinkedList();
		
		for (int i = 0; i < upperBound; i++) {
			head.addHead("Node " + (i + 1));
		}

		System.out.println(head);
		System.out.println();
		
		head.removeHead();
		
		System.out.println(head);
	}
}