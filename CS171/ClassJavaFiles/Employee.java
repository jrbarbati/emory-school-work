/** a generic employee class */
public class Employee
{
	private String name; // name of the employee

	// Example of an _overloaded_ method (constructor)

	public Employee (String n) { 
		name = n;
	}
	public Employee () { 
		name = "Unknown"; 
	}
	public String getName() { 
		return name; 
	}
	public String toString() { 
		return name;
	}
	public double earnings () { 
		return 0;
	}
}


