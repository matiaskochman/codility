package pruebas.y2013;


public class Helium2013 {

	public static void main(String[] arg){
		String S = "barbararhubarb";
		
		String S1 = "bardddddddddddddddbarffffffffffffffbar";
		
		System.out.println(solution(S1));
	}
	
    public static int solution(String S) {
    	
    	if(S.length()>1000000){
    		throw new RuntimeException("string out of bounds");
    	}
    	
    	if(!S.matches("[a-z]*")){
    		throw new RuntimeException("only caracters a-z allowed");
    	}
    	
    	int count=0;
    	int substringSize = 0;
    	//int substringCount = 0;    	
    	int a = S.length()/2;
    	for (int i = 1; i < a; i++) {
    		if(S.substring(0, i).equals(S.substring(S.length()-i, S.length()))){
    			
    			int index =-1;
    			index = S.indexOf(S.substring(0, i), i);
    			count=0;
    			while(index!=S.length()-i){
    				count++;
        			index = S.indexOf(S.substring(0, i), index+1);
    				
    			}
    			if(count>0){
    				count +=2;
    			}
    			
    			if(count > 0){
    				substringSize = S.substring(0, i).length();
    				//substringCount = count;
    			}
    		}
			
		}
    
		return substringSize;
    }	
}
