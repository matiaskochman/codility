package chapter4.excersise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class MaxProductOfTrees {
	
	@Test
	public void test(){
		int[] A = {-3,1,2,-2,5,6};
		int[] B = {-3,1,2};
		
		int result = solution(A);
		System.out.println(result);
	}
	
    public int solution(int[] A) {
    	
    	List<Integer> list = new ArrayList<Integer>();
    	
    	int res = 0;
    	int res2 =0;
    	int max = 0;
    	if(A.length<3 || A.length>100000){
    		throw new RuntimeException("the limit of the array is out of bounds");
    	}
    	
    	for (int i = 0; i < A.length; i++) {
    		if((A[i]<-1000 || A[i]>1000)){
    			throw new RuntimeException("value out of bounds");
    		}

    		list.add(A[i]);
		}

    	
    	// create comparator for reverse order
    	Comparator cmp = Collections.reverseOrder(); 
    	
    	Collections.sort(list,cmp);
    	
        res = list.get(0)*list.get(1)*list.get(2);
    	
        res2 = list.get(0)*list.get(list.size()-1)*list.get(list.size()-2);
        
        if(res>res2){
        	return res;
        	
        }else{
        	return res2;
        }
        
    }
}
