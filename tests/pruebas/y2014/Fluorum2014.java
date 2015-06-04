package pruebas.y2014;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Fluorum2014 {

	@Test
	public void test(){
		
		int[] T ={1,2,3,3,2,1,4};
		
		int[] solu = solution(2,T);
		
		for (int i = 0; i < solu.length; i++) {
			System.out.println(solu[i]);
		}
		
	}
	
    public int[] solution(int K, int[] T) {
        // write your code in Java SE 8
    	
    	if(K>90000 || K<0 || T.length >90000){
    		throw new RuntimeException("out of bounds");
    	}
    	
    	int[] solutionArray = new int[T.length];
    	boolean[] visited = new boolean[T.length];

    	List<Pair> searchList = new ArrayList<Pair>();
    	for (int i = 0; i < T.length; i++) {
			searchList.add(new Pair(T[i],i));
		}
    	
    	Collections.sort(searchList);
    	
    	boolean notFinished = true;
    	Integer city = -1;
    	while(notFinished){
    		city = findACity(searchList, K);
    	}
    	
    	
    	
    	return solutionArray;
    }	


	private Integer findACity(List searchList, Integer K) {
		
		boolean notFinished = true;
		int result = K;
		while(notFinished){
			result = binarySearch(searchList, result);
			
		}
		return null;
	}

	private int findPositionWithResult(int result, int[] T){
    	int pos = 0;
    	for (int position = 0; position < T.length; position++) {
    		if(T[position]==result){
    			pos = position;
    			break;
    		}
		}
    	return pos;
    }
	
	/**
	 * this binary search retrieves the first element if there are duplicates
	 * @param pairList
	 * @param x
	 * @return
	 */
	private int binarySearch(List<Pair> pairList, int x){
		
		int size = pairList.size();
		
		int begin = 0;
		int end = size-1;
		int mid = 0;
		int result = -1;
		
		int count = 0;
		
		while(begin<=end){
			mid = (begin + end) / 2;
			if(pairList.get(mid).x <= x){
				begin = mid+1;
				result = mid;
			}else{
				end = mid-1;
			}
			count++;
		}
		while(pairList.get(result).x.equals(pairList.get(result-1).x)){
			result = result-1;
		}
		System.out.println("iterations in the binarysearch: "+count);
		return result;
	}	
	
}


class Pair implements Comparable{
	public Integer x;
	public Integer y;
	
	public Pair(int x,int y){
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Object o) {
		Pair i = (Pair) o;
		    if(this.x < i.x)
		        return -1;

		    if(this.x > i.x)
		        return 1;

		    return 0;
	}
	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}
	
	
}
