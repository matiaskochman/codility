package pruebas.y2014;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Aluminium2014 {
	
	private int[] arrayTest1 = {5};

	private int[] arrayTest3 = {1005,-4000,3,-3,8,1,-7,3};
	
	private int[] arrayTest2 = {-3,5,3,-3,8,1,-2,1,-3,5,3,-3,8,1,-2,1,-3,5,3,-3,8,1,-2,1,-3,5,3,-3,8,1,-2,1,-3,5,3,-3,8,1,-2,1,-3,5,3,-3,8,1,-2,1};	
	
	
	@Test
	public void test(){
		
		int max = solution(arrayTest2);
		System.out.println(max);
	}
	
	public int solution(int[] A){
		
		if(A.length>100000 || A.length<1){
			throw new RuntimeException("the array is too large");
		}
		
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> listOfList = new ArrayList<Integer>();
		
		
		for (int i = 0; i < A.length; i++) {
			
			if(A[i]>10000 || A[i]<-10000 ){
				throw new RuntimeException("the numbers inside the array are out of size");
			}
			
			for (int j = i; j < A.length; j++) {
				
				if(i<j){
					//there are at least 2 elements in the array
					
					A = swap_one(A,i,j);
					
					int max = maxSlice(A);
					
					list.add(max);
					
					//to avoid creating a new array each time
					//i just put the changed value back
					A = swap_one(A,i,j);
					
					//System.out.println("maxslice: "+max);
				}else {
					//if there is just 1 element in the array
					list.add(A[j]);
				}
			}
			
			Collections.sort(list);
			int temp_Max = list.get(list.size()-1);
			list.clear();
			listOfList.add(temp_Max);
		}
		Collections.sort(listOfList);
		int tempMax = listOfList.get(listOfList.size()-1);
		
		
		return tempMax;
	}
	private int[] swap_one(int[] array, int i, int j) {

		int tempValue = array[i];
		array[i] = array[j];
		array[j] = tempValue;
		
		return array;
	}


	private int maxSlice(int[] array) {
		int max_ending=0;
		int max_slice=0;
		
		for (int i = 0; i < array.length; i++) {
			max_ending = max(0,max_ending + array[i]);
			max_slice = max(max_slice,max_ending);
		}
		return max_slice;
	}

	public int max(int a ,int b){
		
		if(a>b){
			return a;
		}else{
			return b;
		}
	}	
}
