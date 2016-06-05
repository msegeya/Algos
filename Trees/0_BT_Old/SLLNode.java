class SLLNode {
	int data;
	SLLNode next;

	SLLNode(int data) {
		this.data = data;
		this.next = null;
	}	

	SLLNode(int data, 
			SLLNode next){
		this.data = data;
		this.next = next;
	}
}