package chapter5.excersises;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Fish {

	@Test
	public void test(){
		int[] A = {4,3,2,1,5};
		int[] B = {0,1,0,0,0};
		
	}
	
    public int solution(int[] A, int[] B) {
    	
    	int alive_count =0;
    	List<Integer> downstream = new ArrayList<Integer>();
    	int downstream_count = 0;
    	
    	for (int i = 0; i < A.length; i++) {
			if(B[i]==1){
				downstream.add(A[i]);
				downstream_count++;
			}else{
				while (downstream_count!=0) {
					
				}
			}
		}
    	
    	return 0;
    }	
}
