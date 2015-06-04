package chapter8;

import org.junit.Test;

public class PrimalityTest {
	
	Integer lastPrime = 2;
	private StringBuffer sb = new StringBuffer();
	
	@Test
	public void primalityTest(){
		
		int count = 0;
		for (int i = 3; i < 100000000; i++) {
			if(isPrime(i)){
				sb.append(i+" ");
				count++;
				if(count >= 20){
					System.out.println(sb.toString());
					sb = new StringBuffer();
					count = 0;
				}
			}
		}
	}
	
	public boolean isPrime(int n){
		int i = 2;
		
		while(i * i <= n){
			if(n % i == 0){
				return false;
			}
			i+=1;
		}
		return true;
	}
	
	

}
