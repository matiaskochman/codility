package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Ejercicio1 {
	
	@Test
	public void test(){
		int[] A = {5,5,1,7,2,3,5};
		
		int res = solution(5,A);
		
		System.out.println(res);
		
	}
    public int solution(int X,int[] A) {
        // write your code in Java SE 8
        List<Integer> list = new ArrayList<Integer>();
    	
        long[] sums_front = new long[A.length+1];
        long[] sums_rear = new long[A.length+1];
        
        for(int i=1;i<=A.length;i++){
        	if(A[i-1]==X){
        		sums_front[i]=1+sums_front[i-1];
        	}else{
        		sums_front[i]=sums_front[i-1];
        	}
        	
        	if(A[A.length-i]!=X){
        		sums_rear[i]= 1+sums_rear[i-1];
        	}else{
        		sums_rear[i]= sums_rear[i-1];
        		
        	}
        	
        }
        
        for (int i = 1; i < sums_front.length; i++) {
			if(sums_front[i]==sums_rear[sums_front.length-i]){
				return i-1;
			}
		}
 
        return -1;
    }
}
