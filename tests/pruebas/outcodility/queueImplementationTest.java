package pruebas.outcodility;

import java.util.Arrays;

import org.junit.Test;

public class queueImplementationTest {
	
	Integer[] queue = new Integer[10];
	int tail,head=0;
	
	@Test
	public void test(){
		
		Arrays.fill(queue, 0);
		int x = 1;
		if(size()<10){
			push(x++);
		}
		if(size()<10){
			push(x++);
		}
		if(size()<10){
			push(x++);
		}
		if(size()<10){
			push(x++);
		}
		if(size()<10){
			push(x++);
		}
		if(size()<10){
			push(x++);
		}
		if(size()<10){
			push(x++);
		}
		if(size()<10){
			push(x++);
		}
		if(size()<10){
			push(x++);
		}
		if(size()<10){
			push(x++);
		}
		if(size()<10){
			push(x++);
		}
		
		if(!empty()){
			pop();
		}
		if(!empty()){
			pop();
		}
		if(!empty()){
			pop();
		}
		if(!empty()){
			pop();
		}
		if(!empty()){
			pop();
		}
		if(!empty()){
			pop();
		}
		if(!empty()){
			pop();
		}
		if(!empty()){
			pop();
		}
		if(!empty()){
			pop();
		}
		if(!empty()){
			pop();
		}
		if(!empty()){
			pop();
		}
		
	}
	
	
	public void push(int x){
		tail = (tail+1) % queue.length;
		queue[tail] = x;
	}
	
	public int pop(){
		head = (head +1) % queue.length;
		int val = queue[head];
		queue[head] = 0 ;
		return val;
		
	}
	
	public int size(){
		return (tail - head + queue.length) % queue.length;
	}
	
	public boolean empty(){
		return (tail == head);
	}

}
