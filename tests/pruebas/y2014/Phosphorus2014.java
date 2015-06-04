package pruebas.y2014;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Phosphorus2014 {

	@Test
	public void test(){
		
		int[] A = {0,1,2,3,3,2,6,6};
		int[] B = {1,2,3,4,5,6,8,7};
		int[] C = {1,6};
		
		Integer guards = solution(A,B,C);
		
		System.out.println(guards);
	}
	
	public int solution(int[] A,int[] B,int[] C){
		
		List<Integer> exitList = getExits(A, B);
		
		int guards = countGuards(A,B,C, exitList);
		
		return guards;
	}
	
	
	private int countGuards(int[] A,int[] B,int[] C,List<Integer> exitList){
		
		/*
		 * check if a cell block is equals to an exit intersection
		 */
		for (int i = 0; i < C.length; i++) {
			for (Integer exit : exitList) {
				if(exit == C[i]){
					return -1;
				}
			}
		}
		
		int countGuards = 0;
		
		for (int i = 0; i < C.length; i++) {
			countGuards += checkOneCellBlock(A,B,C[i], exitList);
		}
		
		return countGuards;
	}
	
	
	private int checkOneCellBlock(int[] a, int[] b, int cellBlock, List<Integer> exitList) {
		
		/*
		 * first I should check how many corridors in this cell block ends in an exit.
		 * those wich end in an exit need a guard.
		 */
		
		int countGuards = 0;
		
		/*
		 * check the cell block wich are by the side of an exit
		 */
		for (int i = 0; i < a.length; i++) {
			
			if((cellBlock == a[i]) || (cellBlock == b[i])){
				
				if(exitList.contains(a[i]) || exitList.contains(b[i])){
					countGuards++;
					
				}else{
					/*
					 * si soy un cell block y pertenezco a un corredor
					 * y de la otra punta del corredor hay una interseccion, la cual todos sus otros corredores
					 * llevan a una salida sin encontrarse con otra celda entoces sumo un guardia.
					 */
					
					if(cellBlock == a[i]){
						
					}
				}
			}
		}
		
		
		return countGuards;
	}

	

	
	/**
	 * integers that are not repeated in both arrays are exit intersections.
	 */
	private List<Integer> getExits(int[] A,int[] B){
		
		boolean[] intersection_A = new boolean[200001];
		boolean[] intersection_B = new boolean[200001];
		List<Integer> exitList = new ArrayList<Integer>();
		
		/*
		 * A and B are of the same size
		 */
		for (int i = 0; i < A.length; i++) {
			intersection_A[A[i]]=true;
			intersection_B[B[i]]=true;
		}
		
		
		for (int i = 0; i <= 200000; i++) {
			
			if((!intersection_A[i])&&intersection_B[i]){
				exitList.add(i);
			}else if(intersection_A[i]&&(!intersection_B[i])){
				exitList.add(i);
			}
		}
		
		
		return exitList;
	}
}
