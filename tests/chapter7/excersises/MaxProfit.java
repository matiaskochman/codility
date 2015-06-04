package chapter7.excersises;

import org.junit.Test;

public class MaxProfit {

	@Test
	public void test(){
		int[] A = {23171,21011,21123,21366,21013,21367};
		
		int result = solution(A);
		System.out.println(result);
	}
	
    public int solution(int[] A) {
    	
    	int[] diff = new int[A.length];
    	
    	for (int i = 0; i < A.length-1; i++) {
			diff[i]=A[i+1]-A[i];
		}
    	
        return maxSlice(diff);
    }
    
    public int maxSlice(int[] A){
    	int max_ending = 0;
    	int max_slice =0;
    	
    	for (int i = 0; i < A.length; i++) {
			max_ending = max(0,max_ending+A[i]);
			max_slice = max(max_slice,max_ending);
		}
    	return max_slice;
    }
    
    public int max(int a, int b){
    	if(a>b){
    		return a;
    	}else{
    		return b;
    	}
    }
}
