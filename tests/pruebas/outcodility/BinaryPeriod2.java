package pruebas.outcodility;

import org.junit.Test;

public class BinaryPeriod2 {
	
	@Test
	public void test(){
	
		int n = 102;
		
		for (int i = 0; i < 5000; i++) {
			
			System.out.println(binary_period(i));
		}
	}

	int binary_period(int n){
		
		String number = Integer.toBinaryString(n); 
		
		char[] array = number.toCharArray();
		
		for (int p = 1; p <= array.length/2; p++) {
			
			boolean found = true;
			for (int i = 0; i < array.length-p; i++) {
				
				if(array[i]!=array[i+p]){
					found = false;
					break;
				}
			}
			if(found){
				System.out.println(number);
				return p;
			}
		}
		
		return -1;
	}
	
}
