package edu.emory.mathcs.cs323.sort.comparison;

import edu.emory.mathcs.cs323.sort.SortTest;

public class ManySortTests {
	public static void main(String[] args) {
		SortTest t = new SortTest();
		for(int i = 0; i < 100; i++) {
			t.compareSpeeds();
		}
	}
}
