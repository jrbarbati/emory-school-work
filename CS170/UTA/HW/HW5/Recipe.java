public class Recipe
{
	private String       name;
	private Ingredient[] ingredients;
	private double[]     quantities;
	private int          numIng; //Current new empty slot of arrays.

	public Recipe(String name)
	{
		this.name = name;
		this.ingredients = new Ingredient[100];
		this.quantities  = new double[100];
		this.numIng = 0;
	}

	public void addIngredient(Ingredient ing, double qty)
	{
		ingredients[numIng] = ing;
		quantities[numIng]  = qty;
		numIng++;
	}

	public double computeProtein()
	{
		double total = 0.0;
		for(int i = 0; i < numIng; i++)
		{
			total += ingredients[i].computeProtein(quantities[i]);
		}
		return total;
	}

	public double computeFat()
	{
		double total = 0.0;
		for(int i = 0; i < numIng; i++)
		{
			total += ingredients[i].computeFat(quantities[i]);
		}
		return total;
	}

	public double computeCarbohydrates()
	{
		double total = 0.0;
		for(int i = 0; i < numIng; i++)
		{
			total += ingredients[i].computeCarbohydrates(quantities[i]);
		}
		return total;
	}

	public double computeCalories()
	{
		double totalProtein = computeProtein();
		double totalFat     = computeFat();
		double totalCarbs   = computeCarbohydrates();
		double totalCals    = totalProtein * 4 + totalFat * 9 + totalCarbs * 4;
		return totalCals;
	}

	public String nutritionalValues()
	{
		String result = "Nutritional values of " + this.name + ":\n";
		result += "Total Protein: " + computeProtein() + "\n";
		result += "Total Carbohydrates: " + computeCarbohydrates() + "\n";
		result += "Total Fat: " + computeFat() + "\n";
		result += "Total Calories: " + computeCalories() + "\n";
		return result;
	}

	public String toString()
	{
		String result = "Recipe of " + this.name + ":\n";
		for(int i = 0; i < numIng; i++)
		{
			Ingredient ig = ingredients[i];
			result += quantities[i] + " " + ig.getUnit() + " of " + ig.getName() + "\n";
		}
		return result;
	}
}