package pruebas.y2014;

import javax.management.RuntimeErrorException;

public class Nitrogenum2014 {

	public static void main(String[] args){
		
		int[] plots = {2,1,3,2,3};
		int[] seaLevel = {0,1,2,3,1};
		
		int[] solution = solution(plots,seaLevel);
		
		System.out.println(solution);
	}
	
	public static int[] solution(int[] A , int[] B){
		
		if(A.length > 30000|| B.length> 30000){
			throw new RuntimeException("Array out of bound");
		}
		
		int[] islands = new int[B.length] ;
		
		for (int i = 0; i < B.length; i++) {
			
			if(B[i]>100000 || B[i]<0){
				throw new RuntimeException("Sea level out of level");
			}
			
			int islandCounter = 0;
			boolean inAnIsland = false;
			for (int j = 0; j < A.length; j++) {
				
				if(A[j]<0 || A[j]>100000){
					throw new RuntimeException("plot out of level");
				}
				
				if(A[j]>B[i] && !inAnIsland){
					inAnIsland = true;
					islandCounter++;
					continue;
				}else if(A[j]>B[i] && inAnIsland){
					continue;
				}else if(A[j]<=B[i] && inAnIsland){
					inAnIsland=false;
					continue;
				}else if(A[j]<=B[i] && !inAnIsland){
					continue;
				}
			}
			islands[i]=islandCounter;
		}
		
		return islands;
	}
	
}
