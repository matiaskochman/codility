package chapter9;

import java.util.Arrays;

import org.junit.Test;

public class SieveOfEratosthenesTest {
	
	@Test
	public void test_SieveOfEratosthenes(){
		
		StringBuffer sb = new StringBuffer();
		int countBuffer = 1;
		
		int n = 1000000;
		
		long start_time = System.currentTimeMillis();
		
		boolean[] result = sieve(n);
		
		long end_time = System.currentTimeMillis();

		long difference = end_time-start_time;
		
		for (int i = 0; i < n; i++) {
			if(result[i]==true){
				
				sb.append(i+", ");
				countBuffer++;
				if(countBuffer>= 17){
					System.out.println(sb.toString());
					sb = new StringBuffer();
					countBuffer=1;
					
				}
			}
		}
		System.out.println(sb.toString());
		
		/*
		*/
		System.out.println(difference);
		
	}

	
	public boolean[] sieve(int n){
		
		boolean[] sieve = new boolean[n+1];
		
		Arrays.fill(sieve, true);
		
		sieve[0] = sieve[1] = false;
		int k =0;
		int i =2;
		
		while(i*i<=n){
			if(sieve[i]){
				k = i*i;
				while(k<=n){
					sieve[k] = false;
					k +=i;
					
				}
			}
			i += 1;
		}
		
		return sieve;
	}
}
