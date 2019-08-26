public class Circle {
	double radius;

	public Circle(double rad) {
		radius = rad;
	}

	/* Return radius */
	public double getRadius() {
		return radius;	
	}	

	public static void main(String[] args)
	{
		Circle c;
		//c = new Circle(2.0);
		double r = c.getRadius();
		System.out.println ("Radius is: " + r);
	}
};

