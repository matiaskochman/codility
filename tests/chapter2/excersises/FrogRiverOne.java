package chapter2.excersises;

import org.junit.Test;

public class FrogRiverOne {

	@Test
	public void test(){
		int[] A ={1,3,1,4,2,3,5,4};
		
		int[] B ={1,2};
		
		int[] C = new int[20000];
		for (int i = 0; i <= 19995; i++) {
			C[i]=5;
		}
		int t=1;
		for (int i = 19990; i <= 19999; i++) {
			C[i]=t;
			t++;
		}
		
		int respuesta = solution(10, C);
		System.out.println(respuesta);
	}
	
    public int solution(int X, int[] A) {
    	
    	Integer steps = X;
    	
    	int[] position = new int[X+1];
    	for (int i = 0; i < position.length; i++) {
			position[i]=-1;
		}
    	if(X<1 || X>100000){
    		throw new RuntimeException("out of bounds.");
    	}
    	
    	for (int i = 0; i < A.length; i++) {
    		
			if(!(A[i]>0 && A[i]<=X)){
				throw new RuntimeException("value out of bound.");
			}
			if(position[A[i]]==-1){
				position[A[i]]=i;
				steps--;
			}

			if(steps==0){
				return i;
			}
		}
    	return -1;
    	
    }	
}
