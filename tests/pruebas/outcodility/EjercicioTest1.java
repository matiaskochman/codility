package pruebas.outcodility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * Find the unique values into two arrays and show the minimum value among them
 * 
 * int[] A = { 1, 3, 2, 1 };  
    int[] B = { 4, 2, 5, 3, 2 }; 
 * @author Matias
 *
 */
public class EjercicioTest1 {

	@Test
	public void test(){
		int[] A = { 1, 3, 2, 1 };  
		int[] B = { 4, 2, 5, 3, 2 };
		
		int min = solution(A, B);
		
		System.out.println(min);
	}
	
	public int solution(int[] A, int[] B){
		
		List<Integer> not_repeated_a = new ArrayList<Integer>();
		List<Integer> not_repeated_b = new ArrayList<Integer>();
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		checkForRepetition(A, not_repeated_a);
		checkForRepetition(B, not_repeated_b);
		
		Collections.sort(not_repeated_a);
		Collections.sort(not_repeated_b);
		
		if(!not_repeated_a.isEmpty()&&!not_repeated_b.isEmpty()){
			
			if(not_repeated_a.get(0)<not_repeated_b.get(0)){
				return not_repeated_a.get(0);
			}else {
				return not_repeated_b.get(0);
			}
		}
		return 0;
		
	}

	private void checkForRepetition(int[] A, List<Integer> not_repeated_a) {
		boolean repeated = false;
		for (int i = 0; i < A.length-1; i++) {
			if(A[i]!=A[i+1]){
				if(repeated){
					if(i==A.length-2){
						not_repeated_a.add(A[i+1]);
					}
					
					repeated = false;
					continue;
				}
				repeated = false;
				not_repeated_a.add(A[i]);
				
				if(i==A.length-2){
					not_repeated_a.add(A[i+1]);
				}
			}else{
				repeated = true;
			}
		}
	}
}
