package pruebas.y2014;

import org.junit.Test;

public class Natrium2014 {

	@Test
	public void test(){
		
		int[] A={5,3,6,3,4,2};
		int biggerDistance = solution(A);
		
		System.out.println("biggest distance: "+biggerDistance);
	}
	
    public int solution(int[] A) {
    	
    	if(A.length>300000){
    		throw new RuntimeException("size of array out of bounds.");
    	}
    	
    	return n2solution(A);
    }

    private int nSolution(int[] A){
    	
    	
    	
    	return 0;
    }
    
	private int n2solution(int[] A) {
		int maxDistance = 0;
    	int distance = 0;
    	for (int i = 0; i < A.length; i++) {
			for (int j = i; j < A.length; j++) {
				if(A[j]>1000000000 || A[j]<-1000000000){
					throw new RuntimeException("integer out of bounds.");
				}
				if(A[i]<=A[j]){
					distance = j-i;
					
					if(distance>maxDistance){
						
						maxDistance=distance;
					}
				}
			}
		}
        return maxDistance;
	}
    
    
}
