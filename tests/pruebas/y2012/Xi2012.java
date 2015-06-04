package pruebas.y2012;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class Xi2012 {

	@Test
	public void test(){

		/*
		System.out.println(convert(5, 2));
		System.out.println(convert(15, 2));
		
		System.out.println(Integer.parseInt("101",2));
		System.out.println(Integer.parseInt("1111",2));
		*/

		
		System.out.println(solution("101","111111111111111111111111111111",10));
		
	}
	
	
	public int solution(String S, String T, int K) {
		
		if(K<=0 || K >30){
			return 0;
		}
		
		int A = integerfrmbinary(S);
		
		int B = integerfrmbinary(T);
		
		
		String REGEX = "0{"+K+"}";
		Pattern p = Pattern.compile(REGEX);		
		Matcher m = null; 
		int countRegexFound = 0;
		if(A<=B){
			
			for (int i = A; i <= B; i++) {
				//Integer number = convert(i);
				long start_time = System.nanoTime();
				//long start_time = System.currentTimeMillis();
				
				BigDecimal number = convert_B(i);
				String nToString = number.toString();
				m = p.matcher(nToString);
				if(m.find()){
					countRegexFound++;
				}
				
				long end_time = System.nanoTime();
				//long end_time = System.currentTimeMillis();
				
				long difference = end_time-start_time;
				
				System.out.println(i+" iteration time: "+ difference);				
			}
			
		}else{
			return 0;
		}
		
		System.out.println("numeros entre "+A+" y "+B);
        return countRegexFound;
    }
	
	//esto tiene que d
    private Integer convert(int decimal){
        int result = 0;
        int multiplier = 1;

          while(decimal > 0)
            {
              int residue = decimal % 2;
              decimal     = decimal / 2;
              result      = result + residue * multiplier;
              multiplier  = multiplier * 10;
            }
          	return result;
    }	
	
    private BigDecimal convert_B(Integer decimal){
    	
      	long start_time = System.nanoTime();
    	
    	BigDecimal number = new BigDecimal(decimal);
        BigDecimal result = new BigDecimal(0);
        BigDecimal multiplier = new BigDecimal(1);
        BigDecimal residue;
        
          while(number.intValue() > 0){
              residue = number.remainder(new BigDecimal(2));
              number = number.divide(new BigDecimal(2),BigDecimal.ROUND_DOWN);
              result = result.add(residue.multiply(multiplier));
              multiplier = multiplier.multiply(new BigDecimal(10));
           }
          
          
      	long end_time = System.nanoTime();
		//long end_time = System.currentTimeMillis();
		
		long difference = end_time-start_time;
		
		System.out.println(" convert_B time: "+ difference);          
         return result;
    }	    
    
    public int integerfrmbinary(String str){
        double j=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)== '1'){
             j=j+ Math.pow(2,str.length()-1-i);
         }

        }
        return (int) j;
    }
	
}
