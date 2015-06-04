package chapter11;

import java.math.BigDecimal;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void testFibonacci(){
		
		int number = 16000;
		
		//fastResult(number);


		/****************************************************/
		dinamicResult(number);
		
		/*******************************************/
		//recursiveResult(number);		
		/*
		*/
		
	}


	private void recursiveResult(int number) {
		long start_time_recursive_result = System.currentTimeMillis();
		
		Long result = fibonacci_recursive(number);
		
		long end_time_recursive_result = System.currentTimeMillis();
		long difference_recursive_result = end_time_recursive_result-start_time_recursive_result;
		
		System.out.println("recursive result: "+result);
		System.out.println("time: "+difference_recursive_result);
	}


	private void dinamicResult(int number) {
		long start_time_dinamicresult = System.currentTimeMillis();
		
		BigDecimal dinamic_result = fibonacci_dinamically(number);

		long end_time_dinamicresult = System.currentTimeMillis();
		long difference_dinamicresult = end_time_dinamicresult-start_time_dinamicresult;
		
		System.out.println("dinamic result: "+dinamic_result);
		System.out.println("time: "+difference_dinamicresult);
	}


	private void fastResult(int number) {
		long start_time_fastresult = System.currentTimeMillis();
		
		BigDecimal fast_result = fibonacci_ecuation(number);

		long end_time_fastresult = System.currentTimeMillis();
		long difference_fastresult = end_time_fastresult-start_time_fastresult;
		
		System.out.println("fast result: "+fast_result);
		System.out.println("time: "+difference_fastresult);
	}
	
	
	private BigDecimal fibonacci_ecuation(int n){
		
		BigDecimal b1 = new BigDecimal((1d+Math.sqrt(5))/2d);
		BigDecimal b2 = new BigDecimal((1d-Math.sqrt(5))/2d);
		
		b1 = b1.pow(n);
		b2 = b2.pow(n);
		
		BigDecimal b3 = b1.subtract(b2);
		
		BigDecimal divisor = new BigDecimal(Math.sqrt(5));
		
		BigDecimal b4 = b3.divide(divisor);

		return b4;
	}
	
	private Long fibonacci_recursive(Integer n){
		if(n<=1){
			return n.longValue();
		}else{
			return fibonacci_recursive(n-1) + fibonacci_recursive(n-2);
		}
	}
	
	private BigDecimal fibonacci_dinamically(Integer n){
		
		BigDecimal[] fib_b = new BigDecimal[n+2];
		
		fib_b[0]=new BigDecimal(0);
		fib_b[1]=new BigDecimal(1);
		
		for (int i = 2; i < n+1; i++) {
			fib_b[i]=fib_b[i-1].add(fib_b[i-2]);
		}
		
		return fib_b[n];
	}
}
