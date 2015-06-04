package chapter4;

import org.junit.Test;

public class SortTest {

	@Test
	public void test(){
		int[] a1 = {10,5000,100,100000,500000,90000};
		
		int[] solution = countingSort(a1);
		
		System.out.println(solution);
	}
	
	public int[] countingSort(int[] A){
		int size = A.length;
		
		int[] arrayOfCounters = new int[2000000000];
		//int[] arrayOfCounters = new int[20000000];
		
		for (int i = 0; i < A.length; i++) {
			arrayOfCounters[A[i]+1000000000]++;
			//arrayOfCounters[A[i]]++;

		}
		
		int p=0;
		for (int i = 0; i < 20000000; i++) {
			for (int j = 0; j < arrayOfCounters[i]; j++) {
				A[p] = i;
				p+=1;
			}
		}
		return A;
	}
}
