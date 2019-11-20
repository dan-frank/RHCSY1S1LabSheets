class LinkNode {
	private String payload;
	private LinkNode next;

	public LinkNode (String payload) {
		this.payload = payload;
		this.next = null;
	}

	public LinkNode (String payload, LinkNode next) {
		this.payload = payload;
		this.next = next;
	}

	public String getPayload() { return this.payload; }
	public LinkNode getNext() { return this.next; }

	@Override
	public String toString() {
		if (getNext() != null) {
			return getPayload() + "\n" + getNext();
		}
		
		return getPayload();
	}
}
