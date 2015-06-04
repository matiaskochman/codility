package pruebas.outcodility;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class CircularPrimes {

	@Test
	public void test(){
		
		Set<Integer> primeSet = new TreeSet<Integer>();
		
		Set<Integer> rotatedInteger = null;
		for (int i = 1; i <= 1000000; i++) {
			
			rotatedInteger = rotationList(i);
			
			if(rotatedIsPrime(rotatedInteger)){
				primeSet.addAll(rotatedInteger);
			}
			
		}
		
		System.out.println(primeSet.toString());
		
	}
	
	private boolean rotatedIsPrime(Set<Integer> rotatedInteger){
		for (Integer integer : rotatedInteger) {
			if(!isPrime(integer)){
				return false;
			}
			
		}
		return true;
	}
	
	private Set<Integer> rotationList(Integer n){
		
		Set<Integer> rotationSet = new HashSet<Integer>();
		if(n<10){
			rotationSet.add(n);
			return rotationSet;
		}else{
			
			rotationSet.add(n);
			
			String numberToString = n.toString();
			
			char[] charArray = numberToString.toCharArray();
			
			for (int i = 0; i < charArray.length -1; i++) {
				charArray = rotate(charArray);
				String s = new String(charArray);
				Integer inte = new Integer(s);
				rotationSet.add(inte);
			}
			
			return rotationSet;
		}
		
		
	}
	
	private char[] rotate(char[] input){
		char[] output = new char[input.length];
		
		for (int i = 0; i < input.length; i++) {
			if(output.length-1 == i){
				output[0]=input[i];
			}else{
				output[i+1]=input[i];
			}
		}
		
		return output;
	}
	
	private boolean isPrime(int n){
		
		int i = 2;
		
		while(i*i <=n){
			if(n%i ==0){
				return false;
			}
			i+=1;
		}
		return true;
	}
}
