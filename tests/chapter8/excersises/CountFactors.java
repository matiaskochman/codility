package chapter8.excersises;

import org.junit.Test;

public class CountFactors {
	
	@Test
	public void test(){
		
		int N = 2147483646;
		long time1 = System.currentTimeMillis();
		int factors = solution(N);
		long time2 = System.currentTimeMillis();
		System.out.println(factors);
		System.out.println(time2-time1);
	}

    public int solution(int n) {
        // write your code in Java SE 8
    	
    	Long n_long = new Long(n);
    	if(n_long<1 || n_long > Integer.MAX_VALUE){
    		return 0;
    	}
    	
    	
    	long i = 1L;
    	
    	int result = 0;
    	while(i*i<n_long){
    		if(n%i == 0){
    			result+=2;
    		}
    		i++;
    	}
    	if(i*i == n_long){
    		result +=1;
    	}
    	return result;
    }	
	
    
    
}
