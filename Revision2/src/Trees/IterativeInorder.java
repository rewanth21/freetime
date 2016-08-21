package Trees;

import java.util.Stack;

public class IterativeInorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(0);
		root.right = new Node(-10);
		root.left.left = new Node(5);
		root.left.right = new Node(6);
		
		root.right.right = new Node(11);
	
		Inorder(root);
		
		
	}
	
	
	static void Inorder(Node root){
		if(root == null)
			return;
		
		Stack<Node> stack = new Stack<Node>();
		while(true){
			if(root != null){
				stack.push(root);
				root = root.left;
			}
			else{
				if(stack.isEmpty()){
					break;
				}
				root = stack.pop();
				System.out.println(root.data);
				root = root.right;
				
			}
		}
		
		
	}

}
