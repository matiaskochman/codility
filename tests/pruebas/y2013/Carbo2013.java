package pruebas.y2013;

public class Carbo2013 {
	
	
	public static void main(String[] args){
		
		String S = "abababa";
		
		int solution = solution(S);
		
		System.out.println(solution);
	}
	
    public static int solution(String S) {
    	
    	if(S.length()>300000){
    		throw new RuntimeException("string longer than 300000");
    	}
    	
    	int size = S.length();
    	
    	String substring = null;
    	int max = 0;
    	int points = 0;
    	
    	for (int i = 1; i <= size; i++) {
			substring = S.substring(0, i);
			
			points = calculatePoints(substring,S,size);
			
			if(points>max){
				max = points;
			}
			
		}
    	
    	if(max>1000000000){
    		max= 1000000000;
    	}
        return max;
    }

	private static int calculatePoints(String substring, String s, int size) {
		
		int numberOfTimesRepeated = 0;
		int found = 0;
		
		for (int i = 0; i < size; ) {
			
			found = s.indexOf(substring, i);
			
			if(found>=0){
				numberOfTimesRepeated++;
				i=found+1;
			}else{
				break;
			}
		}
		
		int substringSize = substring.length();
		
		return substringSize*numberOfTimesRepeated;
	}
}
