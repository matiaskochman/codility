package chapter6.excersices;

import org.junit.Test;

public class EquiLeader {

	@Test
	public void test(){
		
		
		int[] a1 = new int[100000];
		
		for (int i = 0; i < 49999; i++) {
			Double random = Math.random();
			Double sign = Math.random();
			
			Double d = new Double(1000000000d*random);
			if(sign>0.5){
				a1[i] = d.intValue();
				
			}else{
				a1[i] = -d.intValue();
				
			}
		}
		for (int i = 49999; i < a1.length; i++) {
			a1[i] = 5;
		}
		
		int[] a2 = {4,3,4,4,4,2};
		
		int[] a3 ={3};
		
		int resultado = solution(a2);
		
		
		
		System.out.println(resultado);
	}
	
	int equileaders(int[] A, int leader){
		
		return 0;
	}
	
	
    public int solution(int[] A) {
    	
    	int size = 0;
    	int value=-1;
    	int candidate =-1;
    	for (int i = 0; i < A.length; i++) {
			if(size==0){
				size++;
				value = A[i];
			}else {
				if(value != A[i]){
					size--;
				}else{
					size++;
				}
					
			}
		}
    	if(size >0){
    		candidate = value;
    	}
    	int leader = -1;
    	int count = 0;
    	
    	for (int i = 0; i < A.length; i++) {
			if(candidate == A[i]){
				count++;
			}
		}
    	
    	if(count>(A.length/2)){
    		leader = candidate;
    	}
    		
    	
		int equileader = 0;
		int leader_count_so_far=0;
		for (int i = 0; i < A.length; i++) {
			if(A[i]==leader){
				leader_count_so_far++;
			}
			if((leader_count_so_far>(i+1)/2)){

				if(count-leader_count_so_far>(A.length-(i+1))/2){
					equileader++;
				}
			}
		}
    	
    	return equileader;
    }
    

    

}
