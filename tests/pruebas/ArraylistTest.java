package pruebas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


public class ArraylistTest {
	
	@Test
	public void testArraylist(){
		List<Integer> list = new ArrayList<Integer>();
		int amountToRemove =10000;
		
		System.out.println("1.000.000.000 nanoseconds = 1 second.");
		
		for (int i = 0; i < 1000000; i++) {
			list.add(new Integer(2));
		}
		
		long start_time = System.nanoTime();
		
		for (int i = 0; i < amountToRemove; i++) {
			list.remove(0);
		}

		long end_time = System.nanoTime();

		long difference = end_time-start_time;
		
		System.out.println("dif arraylist remove("+amountToRemove+")= "+ difference+" nanoseconds");
	}

	
	@Test
	public void testLinkedlist(){
		List<Integer> list = new LinkedList<Integer>();
		int amountToRemove =10000;
		
		for (int i = 0; i < 1000000; i++) {
			list.add(new Integer(2));
		}
		
		
		long start_time = System.nanoTime();

		for (int i = 0; i < amountToRemove; i++) {
			
			list.remove(0);
		}


		long end_time = System.nanoTime();

		long difference = end_time-start_time;
		
		
		System.out.println("dif linkedlist remove("+amountToRemove+")= "+ difference+" nanoseconds");
	}
	
}
