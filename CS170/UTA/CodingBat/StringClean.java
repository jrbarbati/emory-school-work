public class StringClean
{
	public static void main(String[] args)
	{
		System.out.println(stringClean("yyzzza"));
		System.out.println(stringClean("abbbcdd"));
		System.out.println(stringClean("Hello"));
	}
	
	public static String stringClean(String s)
	{
		if (s.length() == 1)
		{
			return s;
		}
		else
		{
			String temp = stringClean(s.substring(1, s.length()));
			if (s.charAt(0) == temp.charAt(0))
			{
				return temp;
			}
			else
			{
				return s.charAt(0) + temp;
			}
		}
	}
}
