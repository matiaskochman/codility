package pruebas.outcodility;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class NodesBinaryTree {

	List<Node> leafList = new ArrayList<Node>();
	
	@Test
	public void test(){
		
		int remainingSteps = 6;
		
		for (int j = 1; j <= 2; j++) {
			
			Node node = new Node(null,remainingSteps-j,j);
		}
		
		System.out.println(leafList.size());
	}
	
	
	class Node{
		private Node parentNode;
		private Integer value;
		private Integer remainingSteps;
		private List<Node> nodeList= new ArrayList<Node>();
		private List<Integer> valuesList = new ArrayList<Integer>();
		
		public Node(Node parentNode,Integer remainingSteps,Integer  value){
			this.parentNode = parentNode;
			this.value = value;
			this.remainingSteps = remainingSteps;
			
			insert(remainingSteps, value);
			
		}
		
		public boolean isLeaf(){
			return nodeList.isEmpty();
		}
		
		public boolean isParent(){
			if(parentNode==null){
				return true;
			}else{
				return false;
			}
		}
		
		public void insert(Integer remaniningSteps, Integer value){
			
			if(remaniningSteps == 0){
				
				Node xNode = this.parentNode;
				valuesList.add(this.value);
				while(xNode!=null){
					valuesList.add(xNode.value);
					xNode = xNode.parentNode;
				}
				
				leafList.add(this);
			}
			
			for (int i = 1; i <=2 ; i++) {
				if(remaniningSteps-i >=0){
					Node node = new Node(this,remaniningSteps-i,i);
					nodeList.add(node);
				}else{
					break;
				}
			}
			
		}
	}
	
}
