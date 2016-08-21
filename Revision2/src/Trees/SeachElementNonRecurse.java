package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SeachElementNonRecurse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int element = 6;
	       Node root = new Node(1);
			root.left = new Node(2);
			root.right = new Node(3);
			root.left.left = new Node(4);
			root.left.right = new Node(5);
	SearchElement m = new SearchElement();
	System.out.println("Element is there? : " + m.findElement(root, element));
		
		
	}
	
	boolean searchElement(Node root, int element){
		if(root!=null){
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		while(!queue.isEmpty()){
			Node current = queue.poll();
			if(current.data == element){
				return true;
			}
			 if(current.left != null){
				queue.add(current.left);
			}
			 if(current.right != null){
				 queue.add(current.right);
			 }
				
		}
		return false;
		}
		return false;
	}

}
