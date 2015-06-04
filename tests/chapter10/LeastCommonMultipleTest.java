package chapter10;

import org.junit.Test;

public class LeastCommonMultipleTest {

	@Test
	public void testLeastCommonMultiple(){
		Double a = 20d;
		Double b = 15d;
		
		double result = lcm(a,b);
		
		System.out.println(result);
	}
	
	private double lcm(Double a, Double b){
		return (a*b/gdc(a,b));
	}
	
	private double gdc(Double a, Double b){
		
		if(a%b == 0){
			return b;
		}else{
			return gdc(b,a%b);
		}
		
	}
	
}
