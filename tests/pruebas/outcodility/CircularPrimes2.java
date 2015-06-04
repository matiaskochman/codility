package pruebas.outcodility;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CircularPrimes2 {

	@Test
	public void test(){
		
		List<Integer> primes = new ArrayList<Integer>();
		List<Integer> circularPrimes = new ArrayList<Integer>();
		
		int g = 012;
		
		for (int i = 2; i <= 100; i++) {
			if(isPrime(i)){
				primes.add(i);
			}
		}
		
		for (Integer prime : primes) {
			if (isCircularPrime(prime)) {
				circularPrimes.add(prime);
			}
		}
		
		System.out.println(circularPrimes);
		
		
	}
	
	private boolean isPrime(int n){
		
		int i = 2;
		
		while(i*i<=n){
			if(n%i == 0){
				return false;
			}
			i++;
			
		}
		return true;
	}
	
	private boolean isCircularPrime(Integer prime){
		
		String p = prime.toString();
		
		char[] charArray = p.toCharArray();
		
		for (int i = 0; i < p.length()-1; i++) {
			
			char[] rotated = rotate(charArray);
			
			String s = new String(rotated);
			
			if(!isPrime(new Integer(s))){
				return false;
			}
		}
		
		return true;
	}
	
	private char[] rotate(char[] array){
		
		char[] rotated = new char[array.length];
		char a = array[0];
		for (int i = 0; i < array.length -1 ; i++) {
			rotated[i] = array[i+1];
		}
		rotated[array.length-1] = a;
		
		return rotated;
		
	}
	
}
