package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class maxLevel {

	static int max = 0;
	static int currentmax = 0;
	static int count = 1;
	static int temp = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(0);
		root.left = new Node(1);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.left.left.right = new Node(6);
		root.left.left.right.right = new Node(8);
		root.right.left = new Node(5);
		root.right.left.right = new Node(7);
		
	   max(root);
	   System.out.println();
	   System.out.println(max + " on level " + temp);
		
	}

	 static void max(Node root) {
		if(root == null)
			return;
		
		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		queue.offer(null);
		
		
		while(!queue.isEmpty()){
			Node current = queue.poll();
			
			if(current != null){
				currentmax = currentmax + current.data;
				
				
				
				if(current.left != null){
					queue.offer(current.left);
				}
				
				if(current.right != null){
					queue.offer(current.right);
				}
				
				
				
				if(max < currentmax){
					max = currentmax;
					temp = count;
				}
				
				
				
				
				
				
			}
			else{
				
				System.out.println(currentmax + " on level " + count);
				if(!queue.isEmpty()){
					
					count++;
					queue.offer(null);
					currentmax = 0;
				}
				
			}
			
		}
		
	}

}
