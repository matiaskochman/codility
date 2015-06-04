package chapter3.excersises;


import org.junit.Test;

public class PassingCars {

	@Test
	public void test(){
		int[] A = {0,1,0,1,1};
		int[] test = {0,0,1,1,1,0,1};
		
		int result = solution(test);
		
		System.out.println(result);
	}
    public int solution(int[] A) {
    	int count_zero = 0;
    	int count =0;
    	if(A.length > 100000){
    		throw new RuntimeException("array out of bounds");
    	}
    	
    	int[] counter = new int[A.length];
    	for (int i = 0; i < A.length; i++) {
			if(A[i]<0 || A[i]>1){
				throw new RuntimeException("array value out of range");
			}
			
			if(A[i]==0){
				count_zero+=1;
			}else{
				if(count+count_zero>1000000000){
					return -1;
				}
				count+=count_zero;
			}
		}

        return count;
    }	
}
