package pruebas.outcodility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class LarguestGap {

	@Test
	public void test(){
		int[] A = {10,0,8,2,-1,12,11,3};
		
		int solu = solution(A);
	}
	
    public int solution(int[] A) {
    	
    	if(A.length<2 || A.length >100000){
    		throw new RuntimeException();
    	}
    	Arrays.sort(A);
    	int min = A[0];
    	int max = A[A.length-1];
    	if(min==max){
    		return min;
    	}
    	int[] gap = new int[A.length];
    	
    	List<Integer> gapList = new ArrayList<Integer>();
    	for (int i = 0; i < A.length; i++) {
    		if(A[i]<=min || A[i]>=max){
    			continue;
    		}
    		Double a = new Double(i);
    		Double b = new Double(A[i+1]);
    		Double result = Math.abs(a-b);
    		//gap[i] = result.intValue();
    		gapList.add(result.intValue());
		}
    	Collections.sort(gapList);
    	Arrays.sort(gap);
    	
    	int largestgap = gapList.get(gapList.size()-1);
    	

    	return largestgap;
    }	
}
