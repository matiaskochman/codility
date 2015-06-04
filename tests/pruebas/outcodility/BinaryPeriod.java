package pruebas.outcodility;

import org.junit.Test;

public class BinaryPeriod {
	
    private static StringBuffer printBinaryform(int number,StringBuffer sb) {
        int remainder;

        if (number <= 1) {
            //System.out.print(number);
            return sb.append(number);   // KICK OUT OF THE RECURSION
        }

        remainder = number %2; 
        printBinaryform(number >> 1,sb);
        sb.append(String.valueOf(remainder));
		return sb;
    }	
	
    private int printIntegerForm(String binary){
    	int foo = Integer.parseInt(binary, 2);
    	
    	return foo;
    }
    
    public Integer binary_period(int number){

    	if(number>1000000000 || number <1){
    		throw new RuntimeException("number out of range");
    	}
    	
		StringBuffer sb = new StringBuffer();
		printBinaryform(number,sb);
		String s = sb.toString();
		
		char[] array = sb.toString().toCharArray();
		
		int Q = sb.toString().length();
		int aux = -1;
		int smallestPositiveInteger = -1;
		for (int p = 1; p <= Q/2; p++) {
			for (int k = 0; k < Q-p; k++) {
				if(array[k]!=array[k+p]){
					aux=-1;
					break;
				}
				aux=p;
			}
			if(aux!=-1){
				smallestPositiveInteger=aux;
				break;
			}
			
		}
		
		
    	return smallestPositiveInteger;
    }
    
	//@Test
	public void test(){
		int number = 15;
		
		int result = binary_period(number);
		System.out.println(result);

		number = 102;
		result = binary_period(number);
		System.out.println(result);
		
	}
	@Test
	public void testArray(){
		Integer result = -1;		
		for (int i = 500000; i < 5000000; i++) {
			result = binary_period(i);
			
			StringBuffer sb = new StringBuffer();
			if(result!=-1){
				System.out.println(i);
				System.out.println(result);
				System.out.println(printBinaryform(i, sb));
				System.out.println("");
				
			}
		}
	}

}
