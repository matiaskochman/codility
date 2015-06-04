package chapter13;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CaterPillarMethodTest {

	@Test
	public void testCaterPillarMethod(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(6);
		list.add(2);
		list.add(7);
		list.add(4);
		list.add(1);
		list.add(3);
		list.add(6);
		
		boolean encontro = caterpillarMethod(list, 14);
		
		System.out.println(encontro);
	}
	
	/**
	 * encuentra una secuencia de numeros contiguos igual a 14 dentro del array
	 * @param list
	 * @param search_number
	 * @return
	 */
	private boolean caterpillarMethod(List<Integer> list, int search_number){
		int size = list.size();
		int front = 0,total = 0;
		
		for (int back = 0; back < size; back++) {
			while(front < size && (total + list.get(front)) <= search_number){
				total += list.get(front);
				front += 1;
			}
			if(total == search_number){
				return true;
			}
			total -= list.get(back);
			
		}
		return false;
	}
}
