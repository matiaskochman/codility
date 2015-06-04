package chapter12;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void testBinarySearch(){
		
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < 50000000; i++) {
			
			list.add(i+10);
		}
		
		int num_to_search = 5000003;
		
		int position_result = binarySearch(list, num_to_search);
		
		System.out.println("position in list of searching object of binary search: "+position_result);
		
	}
	
	private int binarySearch(List<Integer> c, int x){
		
		int size = c.size();
		
		int begin = 0;
		int end = size-1;
		int mid = 0;
		int result = -1;
		
		int count = 0;
		
		while(begin<=end){
			mid = (begin + end) / 2;
			if(c.get(mid) <= x){
				begin = mid+1;
				result = mid;
			}else{
				end = mid-1;
			}
			count++;
		}
		System.out.println("iterations in the binarysearch: "+count);
		return result;
	}
}
