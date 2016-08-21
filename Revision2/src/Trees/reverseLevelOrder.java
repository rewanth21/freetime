package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverseLevelOrder {

	static Node root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.right = new Node(8);
		root.right.right.right.left = new Node(10);
		
		
		reverse(root);
		
					
	}

	
	
	
	static void reverse(Node root){
		if(root == null){
			System.out.println("tree is empty");
		}
		
		if(root != null){
			Queue<Node> queue = new LinkedList<Node>();
			Stack<Integer> stack = new Stack<Integer>();
			
			stack.add(root.data);
			queue.add(root);
			
			
			
			while(!queue.isEmpty()){
				Node current = queue.poll();
				System.out.print(current.data + " ");
				
				
				if(current.left != null){
					queue.add(current.left);
					stack.push(current.left.data);
				}
				
				if(current.right != null){
					queue.add(current.right);
					stack.push(current.right.data);
				}
				
				
				
				
				
			}
			System.out.println();
			
			while(!stack.isEmpty()){
			 System.out.print(stack.pop());
			}
			
		}
		
	}
}
