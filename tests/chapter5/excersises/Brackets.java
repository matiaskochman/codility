package chapter5.excersises;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Brackets {
	
	int stack_size=0;
	char[] stack;
	

	@Test
	public void test(){
		String s = "{([])}";
		
		int result = solution(s);
		System.out.println(result);
	}
	
    public int solution(String S) {
    	
    	int size=0;
    	stack = new char[S.length()];
    	
    	String open_b_1 = "(";
    	String close_b_1 = ")";
    	String open_b_2 = "{";
    	String close_b_2 = "}";
    	String open_b_3 = "[";
    	String close_b_3 = "]";
    	
    	List<String> allowed_symbols = new ArrayList<String>();
    	allowed_symbols.add(open_b_1);
    	allowed_symbols.add(close_b_1);
    	allowed_symbols.add(open_b_2);
    	allowed_symbols.add(close_b_2);
    	allowed_symbols.add(open_b_3);
    	allowed_symbols.add(close_b_3);
    	
    	List<String> open_symbols = new ArrayList<String>();
    	open_symbols.add(open_b_1);
    	open_symbols.add(open_b_2);
    	open_symbols.add(open_b_3);
    	
    	List<String> close_symbols = new ArrayList<String>();
    	close_symbols.add(close_b_1);
    	close_symbols.add(close_b_2);
    	close_symbols.add(close_b_3);
    	
    	
    	char[] charArray = S.toCharArray();
    	
    	if(S.length()>200000){
    		return 0;
    	}else if(S.length()==0){
    		return 1;
    	}
    	
    	for (int i = 0; i < charArray.length; i++) {
    		if(open_symbols.contains(Character.toString(charArray[i]))){
    			size++;
    			push(charArray[i]);
    		}else if(close_symbols.contains(Character.toString(charArray[i]))){
    			if(size!=0){
    				if(Character.toString(charArray[i]).equals(close_b_1)){
    					if(Character.toString(stack[stack_size-1]).equals(open_b_1)){
    						pop();
    						size--;
    					}
    				}else if(Character.toString(charArray[i]).equals(close_b_2)){
    					if(Character.toString(stack[stack_size-1]).equals(open_b_2)){
    						pop();
    						size--;
    					}    					
    				}else if(Character.toString(charArray[i]).equals(close_b_3)){
    					if(Character.toString(stack[stack_size-1]).equals(open_b_3)){
    						pop();
    						size--;
    					}    					
    				}
    			}else{
    				return 0;
    			}
    		}
		}
    	if(size==0){
    		return 1 ;
    		
    	}else{
    		return 0;
    	}
    }
    
    private void push(char ch){
    	stack[stack_size]=ch;
    	stack_size++;
    }
    private char pop(){
    	stack_size--;
    	return stack[stack_size];
    	
    }
}
