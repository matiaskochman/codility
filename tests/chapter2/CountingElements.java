package chapter2;

import org.junit.Test;

public class CountingElements {

	
	private Integer[] array = {0,1,1,1,1,2,2,2,2,4,4,4,5,5,5,5};
	
	/*
	 * 
	 * Problem: You are given an integer m such that (1 ¬ m ¬ 1 000 000) and a non-empty, zeroindexed
		array A of n integers: a0, a1, . . . , an−1 such that (0 ¬ ai ¬ m). Count the number of
		occurrences of the values 0, 1, . . . ,m.
	 * 
	 */
	
	@Test
	public void test(){
		
		int[] counter = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			counter[array[i]] +=1;
		}
		
		
		for (int i = 0; i < counter.length; i++) {
			System.out.println("counter["+i+"]="+counter[i]);
		}
		
	}

}
