package chapter3.excersises;

import java.util.Arrays;

import org.junit.Test;

public class PassingCars2 {

	@Test
	public void test(){
		int[] A = {0,1,0,1,1};
		int[] B = {0,0,1,0,0,1,0,0,1};
		int[] C = {1,0};
		
		int solution = solution(C);
		
		System.out.println("solution: "+solution);
	}
	
    public int solution(int[] A) {
    	
    	if(A.length>100000){
    		throw new RuntimeException("array out of values");
    	}
    	
    	int[] p = new int[A.length+1];
    	Arrays.fill(p, 0);
    	
    	int a = 0;
    	int b = 0;
    	
    	for (int i = 0; i < A.length; i++) {
    		
			if(A[i]==0){
				a++;
			}else if(A[i]==1){
				b++;
			}else if(A[i]>1 || A[i]<0){
	    		throw new RuntimeException("incorrect number");
			}
			
			if(a==0){
				b=0;
				continue;
			}
			
			if((p[i] + a*b)>1000000000){
				return -1;
			}
			p[i+1] = p[i] + a*b;
			if(b==1){
				b=0;
			}
		}
    	
    	if(p[p.length-1]>1000000000){
    		return -1;
    	}else{
    		
    		return p[p.length-1];
    	}
    }	
}
