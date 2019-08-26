public class TestDiet 
{
	public static void main(String[] args) 
	{
		IngredientDatabase db = new IngredientDatabase();
		Recipe             r  = new Recipe("All");
		String[]           s  = db.getIngNames();
		for(int i = 0; i < s.length; i++)
		{
			r.addIngredient(db.findIngredient(s[i]), 100);
		}
		System.out.println(r);
		System.out.println(r.nutritionalValues());
	}
}