package site.multithreading.ExecutorServiceExaple2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class LeftTruncablePrimeExcecutor {

	//static List<Integer> ltpList = new ArrayList<Integer>();
	
	public static void main(String[] args){
		
		TreeSet<Integer> ltpList = new TreeSet<Integer>();
		Collections.synchronizedSet(ltpList);
		StringBuffer sb = new StringBuffer();
		int countBuffer = 1;
		
		int limit = 10000;
		
		long start_time = System.currentTimeMillis();
		
		boolean[] result = sieve(limit);
		
		ExecutorService executor = Executors.newFixedThreadPool(4);		
		
		Integer position=0;
		
		List n_primes = extractFirstNPrimes(result, 4,position);
		while(n_primes!=null || !n_primes.isEmpty()){
		
			position =  ((Integer)n_primes.get(0));
			List<Integer> primes = ((List)n_primes.get(1));
			
			Worker w1 = new Worker(primes.get(0));
			Worker w2 = new Worker(primes.get(1));
			Worker w3 = new Worker(primes.get(2));
			Worker w4 = new Worker(primes.get(3));
			
			FutureTask<String> ft1 = new FutureTask<String>(w1);
			FutureTask<String> ft2 = new FutureTask<String>(w2);
			FutureTask<String> ft3 = new FutureTask<String>(w3);
			FutureTask<String> ft4 = new FutureTask<String>(w4);
			
			try{
				 	if(ft1.isDone() && ft2.isDone()&& ft3.isDone()&& ft4.isDone()){
	                    System.out.println("Done");
	                    //shut down executor service
	                    executor.shutdown();
	                    return;
	                }
	                 
	                if(!ft1.isDone()){
		                //wait indefinitely for future task to complete
		                String threadname = ft1.get();
		                System.out.println("FutureTask1 output="+threadname);
	                }
	                if(!ft2.isDone()){
		                //wait indefinitely for future task to complete
		                String threadname = ft2.get(200L, TimeUnit.MILLISECONDS);
		                System.out.println("FutureTask1 output="+threadname);
	                }
	                if(!ft3.isDone()){
		                //wait indefinitely for future task to complete
		                String threadname = ft3.get(200L, TimeUnit.MILLISECONDS);
		                System.out.println("FutureTask1 output="+threadname);
	                }
	                if(!ft4.isDone()){
		                //wait indefinitely for future task to complete
		                String threadname = ft4.get(200L, TimeUnit.MILLISECONDS);
		                System.out.println("FutureTask1 output="+threadname);
	                }
	                 
	                /*
	                System.out.println("Waiting for FutureTask2 to complete");
	                String s = ft2.get(200L, TimeUnit.MILLISECONDS);
	                if(s !=null){
	                    System.out.println("FutureTask2 output="+s);
	                }
	                */
	                
	                n_primes = extractFirstNPrimes(result, 4,position);
	                
			}catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}		
		/*
		for (int i = 0; i < limit; i++) {		
			if(result[i]==true){
				
				String prime = new Integer(i).toString();
				
				if(prime.contains("0")){
					continue;
				}
				
				Worker w = new Worker(i);
				FutureTask<Boolean> ft = new FutureTask<Boolean>(w);
				
				executor.execute(ft);
				
				try {
					if(ft.get()){
						ltpList.add(i);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		*/
		executor.shutdown();
		
		long end_time = System.currentTimeMillis();
		for (Integer i : ltpList) {
			sb.append(i+", ");
			countBuffer++;
			if(countBuffer>= 17){
				System.out.println(sb.toString());
				sb = new StringBuffer();
				countBuffer=1;
				
			}
		}
		
		long difference = end_time-start_time;
		System.out.println("limit: "+limit);
		System.out.println("ltp size: "+ltpList.size());
		System.out.println("ltp time: "+difference);
	}
}
	/**
	 * 
	 * @param result
	 * @param n: amount of primes that I want to extract
	 * @param result[]: array of sieves where are the primes
	 * @return Collection: a collection where the first value is the index of the last prime
	 * extraction of the array, the second value of the collectin is the collection of prime values. 
	 */
	private static List extractFirstNPrimes(boolean[] result, int n, int position){
		
		List result_collection = new ArrayList();
		List<Integer> first_N_Primes = new ArrayList<Integer>();
		
		for (Integer i = position; i < result.length; i++) {
			if(result[i]){
				if(first_N_Primes.size()<n){
					first_N_Primes.add(i);
				}else{
					result_collection.add(i);
					result_collection.add(first_N_Primes);
					break;
				}
			}
		}
		
		return result_collection;
		
	}
	
	private static boolean[] sieve(int n){
		
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
