/**
	Source: - We need to create a SLL for various Data types

	Description: 
		- Make sure the main is in a different class and from the Main class we need to say which type of object should be used to create the SLL.
*/
class NodeList {
	public static void main(String[] args) {
		NodeList list = new NodeList();
		list.prepareList();
	}

	void prepareList() {

		SLL<Integer> sllInt = new SLL<Integer>();
		SLL<String> sllStr = new SLL<String>();

		Node<Integer> root = null;
		root = sllInt.insert(10, root);
		root = sllInt.insert(20, root);
		root = sllInt.insert(30, root);
		sllInt.print(root);

		Node<String> root1 = null;
		root1 = sllStr.insert("One", root1);
		root1 = sllStr.insert("Two", root1);
		root1 = sllStr.insert("Three", root1);
		sllStr.print(root1);		
	}

}

class SLL<E> {
	Node insert(E data, Node<E> root) {
		Node<E> newNode = new Node<E>(data);

		if(null == root) {
			root = newNode;
		} else {
			Node<E> current = root;
			while(null != current.next) {
				current = current.next;
			}
			current.next = newNode;
		}
		return root;
	}

	void print(Node<E> root) {
		Node<E> current = root;
		while(null != current) {
			System.out.println(current.data);
			current = current.next;
		}
	}
}


class Node<E> {
	public E data;
	public Node<E> next;

	Node(E data) {
		this.data = data;
		this.next = null;
	}
}