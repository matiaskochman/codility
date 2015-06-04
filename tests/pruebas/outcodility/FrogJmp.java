package pruebas.outcodility;

import org.junit.Test;

public class FrogJmp {
	
	@Test
	public void test(){
		int resutlt = solution(10, 85, 30);
		System.out.println(resutlt);
	}
    public int solution(int X, int Y, int D) {
    	
    	if((X< 1 || X >1000000000) || (Y< 1 || Y >1000000000)||(D< 1 || D >1000000000)){
    		throw new RuntimeException("values out of bounds");
    	}
    	if(X>Y){
    		throw new RuntimeException("X > Y. Exception");
    	}
    	
    	int t = (Y-X)/D;
    	int rest = (Y-X)%D;
    	if(rest>0){
    		return t+1;
    	}else{
    		return t;
    	}
        
    }	
}
