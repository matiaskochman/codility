package chapter10.excersises;

import org.junit.Test;

public class ChocolateByNumbers1 {
	
	@Test
	public void test(){
		
		int N = 10;
		int M = 4;
		
		System.out.println(solution(N, M));
		
	}

    public int solution(int N, int M) {
        
		int gcd = gcd(N,M);
		int result = N/gcd;
		return result;
    	
    }	
	
	private int gcd(int a,int b){
		if(a%b == 0){
			return b;
		}else{
			return gcd(b,a%b);
		}
	}
}
