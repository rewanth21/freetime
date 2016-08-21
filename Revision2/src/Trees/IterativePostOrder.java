package Trees;

import java.util.Stack;

public class IterativePostOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		Node root = new Node(1);
		root.left = new Node(-10);
		root.right = new Node(11);
		
		root.left.right = new Node(5);
		root.left.right.right = new Node(3);
		root.right.left = new Node(13);
		root.right.right = new Node(16);
	
		
		postOrder(root);
	}
	
	static void postOrder(Node root){
		if (root == null){
			return;
		}
		
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		stack1.push(root);
		
		while(!stack1.isEmpty()){
			
			
			root = stack1.pop();
			stack2.push(root);
			
			if(root.left != null){
				stack1.push(root.left);
			}
			
			if(root.right != null){
				stack1.push(root.right);
			}
			
		
		}
		
		while(!stack2.isEmpty()){
			root = stack2.pop();
			System.out.println(root.data);
		}
	}

}
