/** An hourly employee that makes an earning based on hourly wage */
public class HourlyEmployee extends Employee
{
	private double wage;
	private double hours;
	public HourlyEmployee(String n, double w, double h) {
		super(n); wage = w; hours = h; }
	public double earnings() {
		return wage * hours; }
}
