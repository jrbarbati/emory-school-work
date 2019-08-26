package edu.emory.mathcs.cs323.dynamic;

public class ManyHanoiTests 
{
	public static void main(String[] args)
	{
		HanoiTest test = new HanoiTest();
		
		for(int i = 0; i < 3; i++)
			test.testSpeed();
	}
}	
