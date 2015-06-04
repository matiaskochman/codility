package chapter3.excersises;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Preffix_Suffix_test {

	@Test
	public void test(){
		int[] A = {-1,3,-4,5,1,-6,2,1};
		
		List<Integer> list = solution(A);
		
		for (Integer integer : list) {
			System.out.println(integer);
		}
		
	}
    public List<Integer> solution(int[] A) {
        // write your code in Java SE 8
        List<Integer> list = new ArrayList<Integer>();
    	
        long[] sums_front = new long[A.length+1];
        long[] sums_rear = new long[A.length+1];
        
        for(int i=1;i<=A.length;i++){
            sums_front[i]=A[i-1]+sums_front[i-1];
            sums_rear[i]= A[A.length-i]+sums_rear[i-1];
        }
        
        for (int i = 1; i < sums_front.length; i++) {
			if(sums_front[i]==sums_rear[sums_front.length-i]){
				list.add(i-1);
			}
		}
 
        return list;
    }
    
    
}
