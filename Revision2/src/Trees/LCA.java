package Trees;

import java.awt.List;
import java.util.ArrayList;
import java.util.Stack;

public class LCA {

	static Node root;
	static Node A = new Node(4);
	static Node B = new Node(8);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	   
		LCA m = new LCA();	
	    
	        m.root = new Node(1);
	        m.root.left = new Node(2);
	        m.root.right = new Node(3);
	        m.root.left.left = new Node(4);
	        m.root.left.right = new Node(5);
	        m.root.left.right.left = new Node(7);
	        m.root.left.right.right = new Node(8);
		
		System.out.println(lca(root, A, B));
		
	}

	static Node lca(Node root, Node A, Node B){
		if(root == null){
			return null;
		}
		
		if(root == A || root == B){
			return root;
		}
		
		Node left = lca(root.left, A, B);
		Node right = lca(root.right, A, B);
		
		
		if(left != null && right != null)
			return root;
		
		if(left == null)
			return right;
		else 
			return left;
	}
	 
        
        

}
