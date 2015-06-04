package chapter9.excersises;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CountSemiPrimes {

	@Test
	public void test(){
		int[] A = {1,4,16};
		int[] B = {26,10,20};
		int n = 26;
		
		int[] result = solution(n,A,B);
		
		System.out.println(result);
		
	}
	
    public int[] solution(int N, int[] P, int[] Q) {
    	
    	if(N>50000 || P.length > 30000 || Q.length >30000){
    		throw new RuntimeException("numbers out of bounds.");
    	}
    	List<Integer> result = new ArrayList<Integer>();
    	for (int i = 0; i < P.length; i++) {
    		int amount=0;
    		if(Q[i]>N){
    			throw new RuntimeException();
    		}
    		if(P[i]>=Q[i]){
    			throw new RuntimeException();
    		}
    		for (int j = P[i]; j <= Q[i]; j++) {
    			if(j<1 || j >50000 ){
    				throw new RuntimeException();
    			}
    			
    			int [] B = preparinArrayForFactorization(j);
    			List<Integer> result_1 = factorization(j, B);
    			if(result_1.size()==2){
    				amount++;
    			}
			}
    		result.add(amount);
    		
		}
    	
    	int[] result_array = new int[result.size()];
    	for (int i = 0; i < result_array.length; i++) {
    		result_array[i]=result.get(i);
		}
    	
    	return result_array;
    	
    }
    
    List<Integer> factorization(int t, int[] A){
    	List<Integer>  primeFactors = new ArrayList<Integer> ();
    	
    	while(A[t]>0){
    		primeFactors.add(A[t]);
    		t = t/A[t];
    	}
		primeFactors.add(t);
    	
    	return primeFactors;
    	
    }
    

    int[] preparinArrayForFactorization(int n){
    	int[] A = new int[n+1];
    	int i=2;
    	int k =0;
    	while(i*i<=n){
    		if(A[i]==0){
    			k= i*i;
    			while(k<=n){
    				if(A[k]==0){
    					A[k]=i;
    				}
    				k+=i;
    			}
    		}
    		i+=1;
    	}
    	
    	return A;
    }
}
