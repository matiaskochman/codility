package site.multithreading.ExecutorServiceExaple1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTaskExample {
	public static void main(String[] args){
		
		MyCallable callable1 = new MyCallable(1000);
		MyCallable callable2 = new MyCallable(2000);
		
		FutureTask<String> ft1 = new FutureTask<String>(callable1);
		FutureTask<String> ft2 = new FutureTask<String>(callable2);
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(ft1);
		executor.execute(ft2);
		
		while(true){
			try{
				 if(ft1.isDone() && ft2.isDone()){
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
	                 
	                System.out.println("Waiting for FutureTask2 to complete");
	                String s = ft2.get(200L, TimeUnit.MILLISECONDS);
	                if(s !=null){
	                    System.out.println("FutureTask2 output="+s);
	                }				
			}catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		
	}
}
