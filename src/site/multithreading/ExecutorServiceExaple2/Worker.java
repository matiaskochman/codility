package site.multithreading.ExecutorServiceExaple2;

import java.util.concurrent.Callable;

public class Worker implements Callable{

	private Integer prime;
	public Worker(int prime){
		this.prime = prime;
	}
	
	@Override
	public Boolean call() throws Exception {
		
		System.out.println("Started thread: "+Thread.currentThread().getName());
		//char[] chararray = String.valueOf(prime).toCharArray();
		int size = prime.toString().length();
		String substring;
		for (int i = 0; i < size-1 ; i++) {
			substring = prime.toString().substring(size-1-i, size);
			
			if(!isPrime(new Integer(substring))){
				return false;
			}
		}
		//System.out.println(Thread.currentThread().getName()+", ltp: "+prime+", f-time: "+System.nanoTime());
		return true;
	}

	public Boolean isPrime(int n){
		int i = 2;
		
		if(n==1){
			return false;
		}
		while(i * i <= n){
			if((n % i == 0)){
				return false;
			}
			i+=1;
		}
		return true;
	}
	
	
}
