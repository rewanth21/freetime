package Trees;

import java.util.Stack;

public class PrintAnsestorToAllLeaves {

	static Node root;
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new Node(1);
	        root.left = new Node(2);
	        root.right = new Node(3);
	        root.left.left = new Node(4);
	        root.left.right = new Node(5);
	        root.left.left.left = new Node(7);
	 
	        
	        getAllLeaves(root);
	        while(!stack.isEmpty()){
	        	PrintAncestors(root, stack.pop());
	        	System.out.println();
	        }
	        
	}
	
	static boolean PrintAncestors(Node root, int element){
		
		if(root == null)
			return false;
		
		if(root.data == element){
			System.out.print(root.data + " ");
			return true;
		}
		
		if(PrintAncestors(root.left, element) || PrintAncestors(root.right, element)){
			System.out.print(root.data + " ");
			return true;
		}
		
		
		return false;
		
	}
	
	static void getAllLeaves(Node root){
		
		if(root == null)
			return;
		
		if(root.left == null && root.right == null){
			stack.push(root.data);
		}
		
		getAllLeaves(root.left);
		getAllLeaves(root.right);
		
	}

}
