package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Sum {

	static int sum = 0;
	static int max = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node root = new Node(1);
			root.left = new Node(2);
			root.right = new Node(3);
			root.left.left = new Node(4);
			root.left.right = new Node(5);
			
	  findtotal(root);
	  findtotalrecurse(root);		
		System.out.println(max);
	}
	
	static void findtotalrecurse(Node root){
		if(root == null){
			return;
		}
		
		max = max + root.data;
		
		findtotalrecurse(root.left);
		findtotalrecurse(root.right);
		
		
		
		
		
		
		
	}
	
	static void findtotal(Node root){
		
		if(root != null){
			Queue<Node> queue= new LinkedList<>();
			
			
			queue.add(root);
			
			sum = root.data;
			while(!queue.isEmpty()){
				Node current = queue.poll();
				if(current.left != null){
					
					queue.add(current.left);
					
					sum = sum + current.left.data;
					
				}
				if(current.right != null){
					
					queue.add(current.right);
					
					sum = sum + current.right.data;
				}
			}
			
			
			
		}
		
		System.out.println("total is : " + sum);	
		
	}

}
