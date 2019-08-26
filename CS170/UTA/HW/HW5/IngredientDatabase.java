public class IngredientDatabase 
{
    private Ingredient[] ingredients;
    private int          numIngredients;

    public IngredientDatabase() 
    {
        ingredients     = new Ingredient[20];
        numIngredients  = ingredients.length;
        ingredients[0]  = new Ingredient("flour"  , "g"   , 0.11   , 0.012, 0.75);
        ingredients[1]  = new Ingredient("milk"   , "ml"  , 0.033  , 0.038, 0.047);
        ingredients[2]  = new Ingredient("oil"    , "g"   , 0.0    , 1.0  , 0.0);
        ingredients[3]  = new Ingredient("egg"    , "unit", 0.061  , 0.055, 0.0);
        ingredients[4]  = new Ingredient("sugar"  , "g"   , 0.0    , 0.0  , 1.0);
        ingredients[5]  = new Ingredient("butter" , "g"   , 0.005  , 0.82 , 0.0);
        ingredients[6]  = new Ingredient("cocoa"  , "g"   , 0.19   , 0.22 , 0.12);
        ingredients[7]  = new Ingredient("apple"  , "g"   , 0.2    , 0.0  , 0.09);
        ingredients[8]  = new Ingredient("beef"   , "g"   , 0.24   , 21.0 , 0.0);
        ingredients[9]  = new Ingredient("chicken", "g"   , 0.22   , 7.5  , 0.0);
        ingredients[10] = new Ingredient("cod"    , "g"   , 0.21   , 1.3  , 0.0);
        ingredients[11] = new Ingredient("grapes" , "g"   , 0.00055, 0.0  , 0.14);
        ingredients[12] = new Ingredient("ham"    , "g"   , 0.18   , 0.05 , 0.0);
        ingredients[13] = new Ingredient("lamb"   , "g"   , 0.24   , 0.29 , 0.0);
        ingredients[14] = new Ingredient("pasta"  , "g"   , 0.132  , 0.02 , 0.77);
        ingredients[15] = new Ingredient("popcorn", "g"   , 0.016  , 0.128, 0.762);
        ingredients[16] = new Ingredient("pork"   , "g"   , 0.29   , 0.24 , 0.0);
        ingredients[17] = new Ingredient("chips"  , "g"   , 0.04   , 0.11 , 0.37);
        ingredients[18] = new Ingredient("rice"   , "g"   , 0.026  , 0.001, 0.28);
        ingredients[19] = new Ingredient("turkey" , "g"   , 0.29   , 0.03 , 0.0);
    } 

    public Ingredient findIngredient(String name)
    {
        for(int i = 0; i < ingredients.length; i++)
        {
            if (ingredients[i].getName().equals(name))
                return ingredients[i];
        }
        return null;
    }

    public String[] getIngNames()
    {
        String[] s = new String[numIngredients];
        for(int i = 0; i < ingredients.length; i++)
        {
            s[i] = ingredients[i].getName();
        }
        return s;
    }
}