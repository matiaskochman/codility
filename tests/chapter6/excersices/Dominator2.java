package chapter6.excersices;

import org.junit.Test;

public class Dominator2 {

	@Test
	public void test(){
		int[] A = {3,4,3,2,3,-1,3,3};
		
		int[] B = {-1,-2147483648,-2147483648,-2147483648,-2147483648,1,1,1,-2147483648};
		
		int sol = solution(B);
		
		System.out.println(sol);
	}
	
    public int solution(int[] A) {
    	
    	int value = 0;
    	int size = 0;
    	for (int i = 0; i < A.length; i++) {
			if(size==0){
				size+=1;
				value = A[i];
			}else{
				if(value!=A[i]){
					size-=1;
				}else{
					size+=1;
				}
			}
		}
    	
    	int candidate = -1;
    	
    	if(size>0){
    		candidate = value;
    	}else{
    		return -1;
    	}
    	
    	int leader = -1;
    	
    	int count = 0;
    	
    	for (int i = 0; i < A.length; i++) {
			if(A[i]==candidate){
				count++;
			}
		}
    	if(count>A.length/2){
    		leader = candidate;
    	}
    	
    	for (int i = 0; i < A.length; i++) {
			if(A[i]==leader){
				return i;
			}
		}
    	
    	return -1;
    }	
}
