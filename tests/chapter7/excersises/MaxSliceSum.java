package chapter7.excersises;

import org.junit.Test;

public class MaxSliceSum {
	
	@Test
	public void test(){
		
		int[] A = {3,2,-6,4,0,100000};
		int[] B = {-10};
		int[] B1 = {-10,2,-56};
		int[] B2 = {-10,2,1};
		int[] arrayTestEjemplo = {5,-7,3,5,-2,4,-1};
		
		int solu = solution(arrayTestEjemplo);
		System.out.println(solu);
	}
	
    public int solution(int[] A) {
        // write your code in Java SE 8,

    	if(A.length> 1000000000){
    		throw new RuntimeException();
    	}
    	
    	return maxSlice_n(A);
    }	
	
	public int maxSlice_n(int[] array){
		Long max_ending=0L;
		Long max_slice=0L;
		
		for (int i = 0; i < array.length; i++) {
			if(array[i]>1000000 || array[i]<-1000000){
				throw new RuntimeException();
			}
			
			max_ending = max(-2147483648L,max_ending + ((Integer)array[i]).longValue());
			max_slice = max(max_slice,max_ending);
		}
		return max_slice.intValue();
	}
	public long max(long a ,long b){
		if(a>b){
			return a;
		}else{
			return b;
		}
	}	
	/*
	public int maxSlice_n2(int[] array){
		Long result = -3000000000L;
		
		for (int i = 0; i < array.length; i++) {
			Long sum=0L;
			for (int  j = i;  j < array.length; ++j) {
				sum += array[j];
				result = max(result,sum);
			}
		}
		return result.intValue();
	}	
	*/

}
