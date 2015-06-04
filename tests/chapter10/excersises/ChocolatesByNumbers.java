package chapter10.excersises;

import org.junit.Test;

public class ChocolatesByNumbers {
	@Test
	public void test(){
		
		int N=104;
		int M=10;
		
		
		System.out.println(solution(N,M));
	}
	
    public int solution(int N, int M) {
    	
    	if(N<1 || M<1 || N>1000000000 || M>1000000000){
    		return 0;
    	}
    	
    	boolean[] visited = new boolean[N];
    	
    	int calculedIndex = 0;
    	int count=0;
    	while(!visited[calculedIndex]){
    		visited[calculedIndex] = true;
    		count++;
    		calculedIndex = (calculedIndex + M) % N; 
    	}
    	
        return count;
    }	
}
