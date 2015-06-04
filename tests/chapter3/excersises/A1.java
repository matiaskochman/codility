package chapter3.excersises;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class A1 {

	@Test
	public void test(){
		String a = "abbabba";
		
		int  o = solution(a);
	}
	
    public int solution(String S) {
    	List<String> suffixList = getSuffix(S);
    	List<String> preffixList = getPreffix(S);
    	
    	List<String> matches = new ArrayList<String>();
    	
    	for (String string : suffixList) {
			if(preffixList.contains(string)){
				matches.add(string);
			}
		}
    	
    	if(matches.isEmpty()){
    		return 0;
    	}else{
    		int max=0;
    		for (int i = 0; i < matches.size(); i++) {
    			String s = matches.get(i);
    			
				if(max<s.length()){
					max = s.length();
				}
			}
    		return max;
    	}
    }
    
    public List<String> getSuffix(String original){
    	
    	List<String> list = new ArrayList<>();
    	for (int i = 0; i < original.length()-1; i++) {
			list.add(original.substring(i+1, original.length()-1));
		}
    	return list;
    }
    public List<String> getPreffix(String original){
    	
    	List<String> list = new ArrayList<>();
    	for (int i = 0; i < original.length()-1; i++) {
			list.add(original.substring(0, i));
		}
    	return list;
    }    
}
