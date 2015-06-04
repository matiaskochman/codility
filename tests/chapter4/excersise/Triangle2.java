package chapter4.excersise;

import java.util.Arrays;

import org.junit.Test;

public class Triangle2 {
	
	@Test
	public void test(){
		
		int[] A = {10,2,5,1,8,20};
		
		int[] B = {1,1,100,1,1,1000,1,200,2};
		
		int[] C = {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE};
		int[] D = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};
		
		int solution = solution(C);
		System.out.println("value: "+solution);
		
	}
	
    public int solution(int[] A) {
        // write your code in Java SE 8
    	
    	if(A.length<3 || A.length>100000){
    		return 0;
    	}
    	
    	Arrays.sort(A);
    	
    	for (int i = 0; i < A.length-2; i++) {
			
    		if(A[i]<-2147483648 || A[i]>2147483647 || A[i+1]<-2147483648 || A[i+1]>2147483647 || A[i+2]<-2147483648 || A[i+2]>2147483647){
    			return 0;
    		}
    		
    		long a = new Long(A[i])+new Long(A[i+1]);
    		
    		long b = new Long(A[i+1])+new Long(A[i+2]);
    		
    		long c = new Long(A[i])+new Long(A[i+2]);
    		
    		if(a>A[i+2]){

    			if(b>A[i]){
    				
        			if(c>A[i+1]){
        				return 1;
        			}
    				
    			}
    		}
    		
    		
		}
    	
    	return 0;
    }	

}
