package Trees;

import java.util.Stack;

public class IterativePreOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(19);
		root.left.left = new Node(2);
		root.left.right = new Node(11);
		root.right.left = new Node(-2);
		root.right.right = new Node(6);
		root.left.left.right = new Node(8);
		
		
		PreOrder(root);
	}
	
	static void PreOrder(Node root){
		if (root == null){
			return;
		}
		
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			root = stack.pop();
			System.out.println(root.data);
			
			if(root.right != null){
				stack.push(root.right);
			}
			
			if(root.left != null){
				stack.push(root.left);
			}
		}
		
		
		
	}
	

}
