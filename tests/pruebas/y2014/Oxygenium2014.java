package pruebas.y2014;

public class Oxygenium2014 {

	public static void main(String[] args){
		
		int[] A = {3,5,7,6,3};
		
		int k = 2;
		
		int solu = solution(k,A);
		
		System.out.println(solu);
	}
	
	public static int solution(int k, int[] A){
		int max = 1000000000;
		
		
		if(A.length > 100000){
			throw new RuntimeException("array too large.");
		}
		int boundles = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < A.length; i++) {
			
			
			for (int j = i; j < A.length; j++) {
				
				if(i!=j && A[i]==A[j]){
					continue;
				}
				
				int diff = max(A[i],A[j])-min(A[i],A[j]); 
				if(diff <=k){
					sb.append("("+i+","+j+")"+", ");
					boundles++;
					if(boundles >= max){
						return boundles;
					}
				}
			}
		}
		
		System.out.println(sb.toString());
		return boundles;
	}
	
	public static int max(int a, int b){
		if(a>b){
			return a;
		}else{
			return b;
		}
	}
	public static int min(int a, int b){
		if(a<b){
			return a;
		}else{
			return b;
		}
	}
	
}
