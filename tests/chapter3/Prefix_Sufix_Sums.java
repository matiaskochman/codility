package chapter3;

import org.junit.Test;

public class Prefix_Sufix_Sums {

	private int[] arrayTest1 = {5,-3,3,-3,8,1,-2,3};
	
	private int[] arrayTest2 = {-3,5,3,-3,8,1,-2,1};
	
	//@Test
	public void testArray1(){
		
		int[] prefix_sum = new int[arrayTest1.length +1 ];
		
		for (int i = 1; i <= arrayTest1.length; i++) {
			prefix_sum[i] = prefix_sum[i-1] + arrayTest1[i-1];
		}
		
		
		for (int i = 1; i <= prefix_sum.length; i++) {
			System.out.println("prefix_sum["+i+"]="+prefix_sum[i]);
		}
 	}
	
	//@Test
	public void testArray2(){
		
		int[] prefix_sum = new int[arrayTest2.length +1 ];
		
		for (int i = 1; i <= arrayTest2.length; i++) {
			prefix_sum[i] = prefix_sum[i-1] + arrayTest2[i-1];
		}
		
		
		for (int i = 1; i <= prefix_sum.length; i++) {
			System.out.println("prefix_sum["+i+"]="+prefix_sum[i]);
		}
 	}	
	
	@Test
	public void testMatrix1(){
		
		int[][] prefix_sum = new int[arrayTest1.length +1 ][arrayTest1.length +1 ];
		
		for (int i = 1; i <= arrayTest1.length; i++) {
			
			for (int j = i; j > 0; j--) {
				
				prefix_sum[i][i-j] = prefix_sum[i-1][i-j] + arrayTest1[i-1];
			}
		}
		
		
		for (int i = 0; i < prefix_sum.length; i++) {
			for (int j = 0; j < prefix_sum.length; j++) {
				
				System.out.println("prefix_sum["+i+"]["+j+"]="+prefix_sum[j][i]);
			}
		}
 	}	

	
	
}
