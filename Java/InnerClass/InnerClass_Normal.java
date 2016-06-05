class InnerClass_Normal {

}


// Member Inner class - An inner class without static keyword.
class OuterClass_Member {
     class MemberClass {
     	public void method1() { }
     }
}


// Method local class - The inner class within the method is called method local class.
class OuterClass_Method {

	public int a = 5;

	public void method1() {

		final int k = 10;

		class MethodClass {
			MethodClass() {
				System.out.println(k + a);
			}
		}	
	}
}


// Anonymous inner class
// We have done this many times.
Colelctions.sort(studentsList, new Comparator<Student>() {
					// bla bla bla
});