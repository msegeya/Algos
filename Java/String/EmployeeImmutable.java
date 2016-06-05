/**
	Immutable class has the following features,
	#) The instance variable of the class is final i.e. we cannot change the value of it after creating an object.
	#) The class is final so we cannot create the subclass by extending the super class.
	#) There is no setter methods i.e. we have no option to change the value of the instance variable.

	All the above points makes this class as immutable.
*/

/* NOTE: Both class and the instance should be marked as final. */
final class EmployeeImmutable {
	private final String name;

	public EmployeeImmutable(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
}