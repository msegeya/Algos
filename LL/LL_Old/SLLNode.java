class SLLNode {
	int data;
	SLLNode next;
	SLLNode random;

	SLLNode(int data) {
		this.data = data;
		this.next = null;
		this.random = null;
	}	

	SLLNode(int data, 
			SLLNode next){
		this.data = data;
		this.next = next;
	}
}