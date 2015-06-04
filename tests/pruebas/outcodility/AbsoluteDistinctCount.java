package pruebas.outcodility;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class AbsoluteDistinctCount {

	@Test
	public void test(){
		int[] A={-5,-3,-1,0,3,6};
		int result = solution(A);
		System.out.println(result);
	}
	
    public int solution(int[] A) {
        // write your code in Java SE 8
    	
    	if(A.length>100000){
    		throw new RuntimeException("array out of values");
    	}
    	
    	Set<Integer> existingNumber  = new HashSet<Integer>();
    	
    	for (int i = 0; i < A.length; i++) {
    		Double doubleValue = Math.abs(new Double(A[i]));
    		existingNumber.add(doubleValue.intValue());
		}
    	
    	return existingNumber.size();
    }	
}
