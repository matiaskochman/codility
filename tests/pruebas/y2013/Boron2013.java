package pruebas.y2013;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Boron2013 {
	
	public static void main(String[] args){
		
		int[] A ={1,5,3,4,3,4,1,2,3,4,6,2};

		System.out.println(solution(A));
	}
	
    public static int solution(int[] A) {
    	
    	if(A.length<1 && A.length>200000){
    		throw new RuntimeException("array out of index");
    	}
    	
    	List<Integer> peaks = identifyPeaks(A);
    	
    	Integer flags = calculateFlags(A, peaks);
    	
  
    	return flags;
    }

	private static int calculateFlags(int[] A, List<Integer> peaks) {
		
		int lessDistance = A.length;
    	
		Map<Integer,Integer> distanceMap = new TreeMap<Integer,Integer>();
		
    	Integer distance = 0;
    	
    	for (int i = 1; i < peaks.size(); i++) {
    		int tempFlags = 0;
    		for (int j = i; i < peaks.size(); j++) {
    			
    			distance = Math.abs(peaks.get(i)-peaks.get(i-1));
    			
    			if(peaks.size()<=distance){
    				
    			}
    			//distanceMap.put(peaks.get(i-1),distance);
    			distanceMap.put(distance,peaks.get(i-1));
    			
    		}
		}
    	
    	Set<Integer> keys = distanceMap.keySet();
    	Integer dist = 0;
    	
    	for (Integer distance1 : keys) {
			dist = distance1;
			break;
		}
    	if(dist<peaks.size()){
    		peaks.remove(distanceMap.get(dist));
    		return calculateFlags(A,peaks);
    		
    	}else{
    		
    		return peaks.size();
    	}
    	
    	
	}

	private static List<Integer> identifyPeaks(int[] a) {

		
		List<Integer> peaks = new ArrayList<Integer>();		
		
		for (int i = 1; i < a.length -1; i++) {
			
    		if(a[i-1] <0 || a[i-1]>1000000000){
    			throw new RuntimeException("value out of order");
    		}
			
			if(a[i-1]<a[i] && a[i+1]<a[i]){
				peaks.add(i);
			}
		}
		return peaks;
	}
}
