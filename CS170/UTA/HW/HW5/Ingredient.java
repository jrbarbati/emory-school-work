public class Ingredient
{
	private String name;
	private String unit;
	private double protein;
	private double carbs;
	private double fat;

	public Ingredient(String name, String unit, double protein, double fat, double carbs)
	{
		this.name    = name;
		this.unit    = unit;
		this.protein = protein;
		this.carbs   = carbs;
		this.fat     = fat;
	}

	public double computeProtein(double qty)
	{
		return this.protein * qty;
	}

	public double computeCarbohydrates(double qty)
	{
		return this.carbs * qty;
	}

	public double computeFat(double qty)
	{
		return this.fat * qty;
	}

	public double computeCalories(double p, double c, double f)
	{
		return p * 4.0 + c * 4.0 + f * 9.0;
	}

	public String nutritionalValues(double qty)
	{
		double p   = computeProtein(qty);
		double c   = computeCarbohydrates(qty);
		double f   = computeFat(qty);
		double cal = computeCalories(p, c, f);

		return qty + " " + unit + " of " + name + " contain " + p + " " + unit+
			   " of protein, " + f + " " + unit + " of fat, and " + c + " " +
			   unit + " of carbohydrates, for a total of " + cal + " calories";
	}

	public String getName()    { return this.name; }

	public String getUnit()    { return this.unit; }

	public double getProtein() { return this.protein; }

	public double getCarbs()   { return this.carbs; }

	public double getFat()     { return this.fat; }

	public String toString()   { return this.name; }

}