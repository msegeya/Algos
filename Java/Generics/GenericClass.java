class GenericClass {

	public static void main(String[] args) {
		Box<Integer> intBox = new Box<Integer>();
		Box<String> strBox = new Box<String>();

		intBox.set(new Integer(10));
		strBox.set(new String("Box"));

		System.out.println("Generic Class: Integer => " + intBox.get());
		System.out.println("Generic Class: String => " + strBox.get());
	}
}


class Box<E> {
	private E e;

	public void set(E e) {
		this.e = e;
	}

	public E get() {
		return e;	
	}
}