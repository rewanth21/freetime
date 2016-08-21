package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class mirrorTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Node root = new Node(6);
	       root.left = new Node(4);
	       root.right = new Node(8);
	       root.left.left = new Node(3);
	       root.left.right = new Node(5);
	       root.right.left = new Node(7);
	       root.right.right = new Node(9);

           levelOrder(root);
           System.out.println();
	       mirror(root);
	       levelOrder(root);
	       
	}
	
	static void levelOrder(Node root){
		if (root == null){
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node current = queue.poll();
			System.out.print(current.data + " ");
			
			if(current.left != null){
				queue.add(current.left);
			}
			
			if(current.right != null){
				queue.add(current.right);
			}
		}
	}
	
	
	static void mirror(Node root){
		if(root == null)
			return;
		
		
		
		if(root.left != null && root.right != null){
			Node temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
		
		mirror(root.left);
		mirror(root.right);
		
		
	}

}
