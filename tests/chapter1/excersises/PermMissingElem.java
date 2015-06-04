package chapter1.excersises;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PermMissingElem {

	@Test
	public void test(){
	
		int[] A = {2,3,1,5};
		int resultado = solution(A);
		System.out.println(resultado);
	}
	
    public int solution(int[] A) {
    	Set<Integer> set = new HashSet<Integer>();
    	
    	long sum = 0;
    	if(A.length>100000){
    		throw new RuntimeException("array out of bounds");
    	}
    	
    	for (int i = 0; i < A.length; i++) {
    		
    		if(A[i]>A.length+1){
    			throw new RuntimeException("array value out of bounds");
    		}
    		set.add(A[i]);
			sum+=A[i];
		}
    	if(set.size()!=A.length){
    		throw new RuntimeException("duplicated elements");
    	}
    	
    	int p = A.length+1;
    	long sumatoria = p*(p +1)/2;
    	
    	Long result = sumatoria - sum;
    	
        return result.intValue();
    }	
}
