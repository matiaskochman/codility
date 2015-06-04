package chapter9;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FactorizationTest {

	@Test
	public void test_factorization(){
		
		int n = 50000858;
		int p = 500;
		List<Double> primeFactors = factorization(p, preparingFactorization(p));
		
		for (Double double1 : primeFactors) {
			System.out.print(double1+", ");
		}
	}
	
	
	private List<Double> factorization(int number, double[] f){
		List<Double> primeFactors = new ArrayList<Double>();
		
		while(f[number] > 0){
			primeFactors.add(f[number]);
			number /= f[number];
		}
		
		primeFactors.add(new Double(number));
		
		return  primeFactors;
	}
	private double[] preparingFactorization(int n){
		double[] integerVector = new double[n+1];
		
		int i = 2;
		int k = 0;
		
		while(i*i <= n){
			if(integerVector[i] == 0){
				k = i*i;
				while(k <= n){
					if(integerVector[k] == 0){
						integerVector[k] = i;
					}
					k +=i;
				}
			}
			i +=1;
		}
		
		return integerVector;
	}
}
