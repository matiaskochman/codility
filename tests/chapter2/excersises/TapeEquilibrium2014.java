package chapter2.excersises;

import org.junit.Test;

public class TapeEquilibrium2014 {

	@Test
	public void test(){
		
		int[] A = {3,1,2,4,3};
	
		int result = solution(A);
		
		System.out.println(result);
		
	}
	
    public int solution(int[] A) {
    	
    	Double minimalDiff = -1d;
    	
    	Integer[] B = new Integer[A.length];
    	
    	if(A.length <2 || A.length >100000){
    		throw new RuntimeException("array out of lenght");
    	}
    	
    	for (int i = 0; i < A.length; i++) {
			if(A[i]<-1000 || A[i]>1000){
				throw new RuntimeException("array value out of parameters");
			}
			if(i==0){
				B[i]=A[i];
			}else{
				B[i]=B[i-1]+A[i];
			}
			
		}
    	
    	for (int i = 0; i < B.length -1; i++) {
    		if(minimalDiff<0 || minimalDiff > Math.abs(B[i].doubleValue()- (B[B.length-1]-B[i])) ){
    			minimalDiff = Math.abs(B[i].doubleValue()- (B[B.length-1]-B[i]));
    		}
		}
    	
    	return minimalDiff.intValue();
    }	
}
