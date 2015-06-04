package pruebas.outcodility;

import org.junit.Assert;
import org.junit.Test;

public class ReverseStringTest {

	@Test
	public void test(){
		
		//String test = reverse("hello world!");
		String t1 = "hello world!";
		String test = reverse_recursive_the_return(t1);
		Assert.assertEquals(test,"!dlrow olleh");
	}
	
	/*
	 * first task is to revert a string - input message: hello world! output message: !dlrow ollehâ€?
	 */
	private String reverse(String original){
		
		char[] original_array = original.toCharArray();
		
		char[] result_array = new char[original.length()];
		
		for (int i = 0; i<original.length(); i++) {
			result_array[i] = original_array[original.length()-1-i];
		}
		
		String result = new String(result_array);
		return result.toString();
	}
	
	public  String reverse_recursive(String str) {
	    if ((null == str) || (str.length() <= 1)) {
	        return str;
	    }
	    String a = reverse_recursive(str.substring(1)) + str.charAt(0); 
	    return a;
	}
	
	public String reverse_recursive_the_return(String str){
		if(null == str || str.length()<=1){
			return str;
		}
		
		return str.substring(str.length()-1) + reverse_recursive_the_return(str.substring(0,str.length()-1));
	}
}
