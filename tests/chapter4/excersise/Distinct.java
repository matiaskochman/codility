package chapter4.excersise;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class Distinct {

	@Test
	public void test(){
		int[] A = {2,1,1,2,3,1};
		
		int result = solution(A);
		System.out.println(result);
	}
	
    public int solution(int[] A) {
    	
    	Set<Integer> set = new HashSet<Integer>();
    	if(A.length>100000){
    		throw new RuntimeException("array out of bounds");
    	}
    	
    	for (int i = 0; i < A.length; i++) {
    		set.add(A[i]);
		}
    	
        return set.size();
    }	
}
