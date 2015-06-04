package chapter6.excersices;

import org.junit.Test;

public class Dominator {
	
	@Test
	public void test(){
		int[] A = {3,4,3,2,3,-1,3,3};
		
		int result = solution(A);
		System.out.println(result);
	}
	
    public int solution(int[] A) {
    	
    	int dominator=0;
    	int size = 0;
    	int count=0;
    	int dominatorIndex=-1;
    	int value=0;
    	int candidate = 0;
    	
    	if(A.length>100000){
    		return -1;
    	}
    	for (int i = 0; i < A.length; i++) {
    		
    		if(A[i]<-2147483648 || A[i]>2147483647){
    			return -1;
    		}
			if(size == 0){
				value = A[i];
				size++;
				dominatorIndex = i;
			}else{
				if(value!=A[i]){
					size--;
				}else{
					size++;
				}
			}
		}
    	if(size>0){
    		candidate = value;
    	}
    	for (int i = 0; i < A.length; i++) {
			if(A[i]==candidate){
				count++;
			}
		}
    	if(count>(A.length/2)){
    		dominator=candidate;
    		return dominatorIndex;
    	}else{
    		return -1;
    	}
    }	
}
