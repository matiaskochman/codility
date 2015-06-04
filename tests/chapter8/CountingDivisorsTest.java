package chapter8;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CountingDivisorsTest {
	
	List<String> divisorList = new ArrayList<String>();
	StringBuffer sb = new StringBuffer();
	
	@Test
	public void countDivisors(){
		int result = divisors(800);
		System.out.println(result);
		
		System.out.println(sb.toString());
		
	}

	
	public int divisors(int n){
		int i = 1;
		int result = 0;
		while (i * i < n){
			if (n % i == 0){
				sb.append(new Integer(i).toString()+", "+n/i+", ");
				
				result += 2;
			}
			i += 1;
		}
		if (i * i == n){
			result += 1;
		}
		return result;
	}
}
