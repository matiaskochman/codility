package chapter7;

import java.util.Random;

import org.junit.Test;

public class MaxSliceTest {
	
	private int[] arrayTest1 = {5,-3,3,-3,8,1,-2,3};
	
	private int[] arrayTest2 = {-3,5,3,-3,8,1,-2,1,-3,5,3,-3,8,1,-2,1,-3,5,3,-3,8,1,-2,1,-3,5,3,-3,8,1,-2,1,-3,5,3,-3,8,1,-2,1,-3,5,3,-3,8,1,-2,1};
	
	private int[] arrayTestEjemplo = {5,-7,3,5,-2,4,-1};
	
	
	
	
	@Test
	public void maxSliceTest_n(){

		int[] largeTest= new int[100000];
		Random r = new Random();
		for (int i = 0; i < largeTest.length; i++) {
			largeTest[i] = r.nextInt();
		}
		
		long startTime = System.nanoTime();    
		int max = maxSlice_n(largeTest);
		long estimatedTime = System.nanoTime() - startTime;
		
		System.out.println(max);
		System.out.println("nanotime: "+estimatedTime);
		
		long startTime2 = System.nanoTime();    
		int max2 = maxSlice_n2(largeTest);
		long estimatedTime2 = System.nanoTime() - startTime2;		
		
		System.out.println(max2);
		System.out.println("nanotime2: "+estimatedTime2);
	}
	
	
	public int maxSlice_n2(int[] array){
		int result = 0;
		
		for (int i = 0; i < array.length; i++) {
			int sum=0;
			for (int  j = i;  j < array.length; ++j) {
				sum += array[j];
				result = max(result,sum);
			}
		}
		return result;
	}
	
	
	public int maxSlice_n(int[] array){
		int max_ending=0;
		int max_slice=0;
		
		for (int i = 0; i < array.length; i++) {
			max_ending = max(0,max_ending + array[i]);
			max_slice = max(max_slice,max_ending);
		}
		return max_slice;
	}
	
	
	public int max(int a ,int b){
		if(a>b){
			return a;
		}else{
			return b;
		}
	}

}
