package edu.emory.mathcs.cs323.hw.hybridsort;

public class ManyHybridSortTests {
	public static void main(String[] args) {
		HybridSortTest t = new HybridSortTest();
		
		for(int i = 0; i < 1000; i++) 
			t.testSpeed();
	}
}
