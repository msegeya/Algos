import java.util.*;

class GenericList<T> {
	
	private List<T> list;

	public GenericList() {
		this.list = new ArrayList<T>();
	}

	public void add(T data) {
		this.list.add(data);
	}

	public T get(int index) {
		this.list.get(index);
	}
}

// You can call the above class methods as below.
// GenericList<String> list_str = new GenericList<String>(); list_str.add("one"); .. 
// GenericList<Integer> list_int = new GenericList<Integer>(); list_int.add(1); .. 


/*
	//NOTE: Below code is not generic.

class NormalList {
	private List<String> list;

	public NormalList() {
		this.list = new ArrayList<String>();
	}

	public void add(String s) {
		this.list.add(s);
	}

	public String get(int index) {
		return this.list.get(index);
	}
}
*/