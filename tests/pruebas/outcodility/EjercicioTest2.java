package pruebas.outcodility;

import java.util.Arrays;

import org.junit.Test;

/**
 *  Count how many times a value is present in an array. If times > 1000000000, then return 1000000000
 * @author Matias
 *
 */
public class EjercicioTest2 {

	@Test
	public void test(){
		int[] A={1,8,8,8,8};
		
		int times = solution(A);
		System.out.println(times);
		
	}

	public int solution(int[] A){
		
		Arrays.sort(A);
		
		int max = 0;
		int repetitions = 0;
		int repeatedNumber = 0;
		Integer val = null;
		
		for (int i = 0; i < A.length; i++) {
			
			if(val==null){
				val = A[i];
				
				continue;
			}
			
			
			if(val == A[i]){
				repetitions++;
			}else{
				repetitions=0;
				val = A[i];
			}
			if(repetitions>max){
				max=repetitions;
				repeatedNumber = val;
			}
		}
		
		System.out.println(repeatedNumber);
		return max+=1;
	}
}
