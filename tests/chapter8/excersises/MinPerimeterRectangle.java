package chapter8.excersises;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class MinPerimeterRectangle {
	
	@Test
	public void test(){
		System.out.println(solution(36));
	}
	
    public int solution(int N) {
    	
    	if(N< 1 || N>1000000000){
    		throw new RuntimeException("area out of range");
    	}
    	
    	TreeMap divisors = divisors(N);
    	
    	Map.Entry<Integer,Integer> entry = divisors.lastEntry();
    	
    	
        return 2*(entry.getKey()+entry.getValue()); 
    }
    
    
    TreeMap<Integer,Integer> divisors(int N){
    	TreeMap<Integer,Integer> divisors = new TreeMap<Integer,Integer>();
    	
    	int i=1;
    	while(i*i<=N){
    		if(N%i==0){
    			divisors.put(i,N/i);
    		}
    		i++;
    	}
    	
    	return divisors;
    }
}
