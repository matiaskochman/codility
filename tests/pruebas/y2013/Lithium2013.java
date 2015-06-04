package pruebas.y2013;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lithium2013 {

	public static void main(String[] args){
		
		int[][] A = {{1,2},{2,4},{4,3},{2,3},{1,3}};
		int[][] B = {{3,2,5000},{2,4,3},{2,3,5000},{2,3,4},{1,3,4},{2,3,5000},{2,3,4}};
		
		int p = 5000;
		
		
		int solu = solution(B,p);
		
		//solu = solution({{3,2,1},{2,4,3},{4,3,1},{2,3,4},{1,3,4}},p);
		
		System.out.println(solu);
	}
	
    public static int solution(int[][] A, int P) {
        // write your code in Java SE 8
    	
    	if(P>1000000000){
    		throw new RuntimeException("array out of bounds");
    	}
    	
    	if(A.length >500 || A.length<1){
    		throw new RuntimeException("array out of bounds");
    	}
    	
    	if(A[0].length > 500 || A[0].length <1){
    		throw new RuntimeException("array out of bounds");
    	}
    	
    	List allClockDistances = new ArrayList();
    	
    	for (int i = 0; i < A.length; i++) {
    		List<Integer> thisClockDistances = new ArrayList<Integer>();
    		List<Integer> clockPositions = new ArrayList<Integer>();
    		
			for (int j = 0; j < A[i].length; j++) {
				
				if(A[i][j]<0 || A[i][j]>P){
		    		throw new RuntimeException("value out of bounds");
				}
				clockPositions.add(A[i][j]);
			}
			
			Collections.sort(clockPositions);
			for (int j = 1; j < clockPositions.size(); j++) {
				thisClockDistances.add(clockPositions.get(j)-clockPositions.get(0));
			}
			allClockDistances.add(thisClockDistances);
		}
    	
    	int counter = 0;
    	for (int i = 0; i < A.length; i++) {
    		for (int j = i+1; j < allClockDistances.size(); j++) {
    			if(allClockDistances.get(i).equals(allClockDistances.get(j))){
    				counter++;
    			}
    			
    		}
			
		}
    	return counter;
    }	
}
