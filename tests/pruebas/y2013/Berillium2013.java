package pruebas.y2013;

import java.util.HashSet;
import java.util.Set;


public class Berillium2013 {

	public static void main(String args[]){
		int[] A = {3,5,7,3,3,5};
		System.out.println(solution(A));
	}
	
	public static int solution(int[] A){
		
		if(A.length>40000){
			throw new RuntimeException("array out of limits");
		}
		
		StringBuffer buffer = new StringBuffer();
		int countPrefixSuffixAchived=0;
		
		for (int i = 0; i < A.length; i++) {
			
			Set<Integer> prefixSet = new HashSet<Integer>();
			
			for (int t = 0; t < i+1; t++) {
				check(A[t]);
				prefixSet.add(A[t]);
				
			}
			for (int j = 0; j < A.length; j++) {
				
				Set<Integer> suffixSet = new HashSet<Integer>();
				for (int j2 = j; j2 < A.length; j2++) {
					check(A[j2]);
					
					suffixSet.add(A[j2]);
					
				}
				if(suffixSet.containsAll(prefixSet)){
					if(prefixSet.containsAll(suffixSet)){
						countPrefixSuffixAchived++;
						buffer.append("("+i+","+j+"), ");
						
					}
				}
			}

		}
		return countPrefixSuffixAchived;
	}
	
	private static void check(int a){
		if(a<-1000000000 || a>1000000000){
			throw new RuntimeException("value of of order");
		}
	}
	
}
