
package chapter10;

import org.junit.Test;

public class GreatestCommonDivisorTest {

	@Test
	public void testGdc(){
		
		double a= 145;
		double b = 115;
		
		double greatestCommonDivisor = gdc(a,b);
		
		System.out.println(greatestCommonDivisor);
	}
	
	private double gdc(Double a, Double b){
		
		if(a%b == 0){
			return b;
		}else{
			return gdc(b,a%b);
		}
		
	}
	
}
