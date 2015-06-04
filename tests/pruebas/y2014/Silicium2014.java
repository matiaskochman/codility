package pruebas.y2014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Silicium2014 {

	public static void main(String[] args){
		Silicium2014 s = new Silicium2014();
        
        int[] A = {1,3}; // X axis
        int[] B = {1,5}; // Y axis        
        
        System.out.println(s.solution(6,7,3,A,B));
    }	
	
	public int solution(int X, int Y, int K, int[] A, int[] B) {
        
		int[] xAxis = new int[A.length+1];
		int[] yAxis = new int[B.length+1];

		xAxis = Arrays.copyOf(A, A.length+1);
		xAxis[xAxis.length - 1]= X;
		yAxis = Arrays.copyOf(B, B.length+1);
		yAxis[yAxis.length - 1]= Y;
		
        List<Integer> surfaceList = new ArrayList<Integer>();
        
        for(int posArrayA = xAxis.length;posArrayA>0;posArrayA--){
        	
        	for(int posArrayB = yAxis.length; posArrayB>0;posArrayB--){
        		
        		if((posArrayB-2 >= 0)&&(posArrayA-2 >= 0)){
        			surfaceList.add(calculateCake(xAxis[posArrayA-1],xAxis[posArrayA-2],yAxis[posArrayB-1],yAxis[posArrayB-2]));
        			
        		}else if((posArrayB-2 <= 0)&&(posArrayA-2 >= 0)){
        			surfaceList.add(calculateCake(xAxis[posArrayA-1],xAxis[posArrayA-2],yAxis[posArrayB-1],0));
        			
        		}else if((posArrayB-2 >= 0)&&(posArrayA-2 <= 0)){
        			surfaceList.add(calculateCake(xAxis[posArrayA-1],0,yAxis[posArrayB-1],yAxis[posArrayB-2]));
        			
        		}else if((posArrayB-2 <= 0)&&(posArrayA-2 <= 0)){
        			surfaceList.add(calculateCake(xAxis[posArrayA-1],0,yAxis[posArrayB-1],0));
        			
        		}
        	}
        
        }
        Collections.sort(surfaceList);
        return surfaceList.get(surfaceList.size()-K);
    }
    
    private int calculateCake(int X,int T,int Y,int U){
        int xSide = X - T;
        int ySide = Y - U;
        
        return ySide*xSide;
    }
}
