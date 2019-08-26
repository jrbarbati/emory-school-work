/** A salaried employee that makes a fixed salary */
public class SalariedEmployee extends Employee
{
	private double weeklySalary;

	public SalariedEmployee(String n, double salary) {
		//XXX // call superclass constructor
		super(n);
		weeklySalary = salary; 
	}

	// Example of an _overridden_ method
	public double earnings() {
		return weeklySalary; 
	}

	public void printName() {
		System.out.println (super.getName());
	}

	public String toString()
	{
		return "Salaried Employee";
	}


	public static void main(String[] args)
	{
		SalariedEmployee homer = new SalariedEmployee("Homer Simpson", 5);
		Employee e = homer;
		Employee marge = new Employee("Marge Simpson");
		
		System.out.println (homer);
		System.out.println (e);
		System.out.println (marge);

	}
}

