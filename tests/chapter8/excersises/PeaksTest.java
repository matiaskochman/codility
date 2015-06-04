package chapter8.excersises;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class PeaksTest {
	
	
	@Test
	public void test(){
		int[] A = {1,2,3,4,3,4,1,2,3,4,6,2};
		
		int amount = solution(A);
		
		System.out.println(amount);
	}
	
    public int solution(int[] A) {
    	
    	
    	List<Integer> divisors = divisors(A.length);

    	for (Integer d : divisors) {
			
    		int frecuency = A.length / d;
    		
    		for (int part = 0; part < d-1; part++) {
				int index_a = part * frecuency;
    			int index_b = (part * frecuency) + frecuency-1;
			}
    		
		}
        return amountOfPeaks(A, -1, -1,0,A.length-1);
    }	

	public List<Integer> divisors(int n){
		List<Integer> divisors = new ArrayList<Integer>();
		int i = 1;
		int result = 0;
		while (i * i < n){
			if (n % i == 0){
				
				divisors.add(i);
				divisors.add(n/i);
				result += 2;
			}
			i += 1;
		}
		if (i * i == n){
			result += 1;
		}
		Collections.sort(divisors);
		return divisors;
	}
    
    
    
    private int amountOfPeaks(int[] a, int adyacentLeft, int adyacentRight, int index_from, int index_to){
    	
    	int peaksAmount = 0;
    	
    	if(a.length>1){
    		
    		if(a[0]<0){
    			return 0;
    		}
    		
    		if(adyacentLeft<a[0] && a[0]>a[1]){
    			peaksAmount+=1;
    		}else if(a[a.length-2]<a[a.length-1] && a[a.length-1]>adyacentRight){
    			peaksAmount+=1;
				
			}
    		
    		if(a.length>2){
    			for (int i = index_from; i <= index_to -2; i++) {
    				
    	    		if(a[i]<0||a[i+1]<0||a[i+2]<0){
    	    			return 0;
    	    		}
    				
					if(a[i]<a[i+1] && a[i+1] > a[i+2]){
						peaksAmount+=1;
					}
				}
    			
    		}
    		
    	}else{
    		if(a[0] > adyacentLeft && a[0] > adyacentRight){
    			peaksAmount+=1;
    		}
    	}
    	
    	return peaksAmount;
    }
}
