package chapter5.excersises;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class Stonewall {
	@Test
	public void test(){
		
		int[] H={8,8,5,7,9,8,7,4,8};

		int[] p={2,2,3,4,5,5,4,4,2,1,1};

		System.out.println(solution(p));
	}
	
    public int solution(int[] H) {
    	
    	if(H.length>100000){
    		throw new RuntimeException();
    	}
    	
    	int[] stack = new int[H.length];
    	
    	Arrays.fill(stack, 0);
    	
    	int index=0;
    	int stones = 0;
    	for (int i = 0; i < H.length; i++) {
    		
			if(H[i]>1000000000 || H[i]<0){
				throw new RuntimeException();
			}
			
			while ((index>0) && stack[index-1]>H[i]){
				index -= 1;
			}
			if(index>0 && stack[index-1]==H[i]){
				continue;
			}else{
				stones+=1;
				stack[index] = H[i];
				index +=1;
			}

			
		}
    	return stones;
    	
    }


}
