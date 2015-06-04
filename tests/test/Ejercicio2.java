package test;

import org.junit.Test;

public class Ejercicio2 {

	@Test
	public void test(){
		int[] A = {1,0,0,1,1};
		
		int [] sol = solution(A);
		
		
	}

    public int[] solution(int[] A) {
    	
    	if(A.length>100001){
    		throw new RuntimeException();
    	}
    	
    	int sum = sum(A);
    	
    	
    	/*
    	String binary_number_string = sb.toString();
    	
    	Integer number = Integer.parseInt(binary_number_string,2);
    	
    	*/
    	int number_negative = -sum;
    	
    	String binary_number_negative = Integer.toBinaryString(number_negative);
    	
    	char[] char_array = binary_number_negative.toCharArray();
    	
    	int[] array = new int[char_array.length];
    	
    	for (int i = 0; i < char_array.length; i++) {
    	    String s = new String(char_array);
			//array[i]= s.intValue();
		}
        return array;
    }	
    
    public int sum(int[] A){
    	Double sum = 0D;
    	double base = -2;
    	for (int i = 0; i < A.length; i++) {
    		Double y = new Double(i);
    		double res = Math.pow(base, y);
			sum =  res*new Double(A[i]) + sum;
		}
    	
    	return sum.intValue();
    }
}
