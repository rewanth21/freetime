package Trees;

import java.util.Stack;

public class GivenSumInAPath {

	static Node root;
	static int total = 0;
	static Stack<Integer> stack = new Stack<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		root = new Node(1);
	        root.left = new Node(2);
	        root.right = new Node(3);
	        root.left.left = new Node(4);
	        root.left.right = new Node(5);
	        root.left.left.left = new Node(7);
	        
	        int sum = 8;
	        
	        getAllLeaves(root);
	        while(!stack.isEmpty()){
	        	IsSumAvailable(root, stack.pop(), sum);
	        	
	        	if(sum == total){
	        		System.out.print("= " + sum);
	        	}
	        	else{
	        		System.out.print("Total for this root to node is not equal to " + sum);
	        	}
	        	
	        	total = 0;
	        	System.out.println();
	        }
	        
	}
	
	static boolean IsSumAvailable(Node root, int element, int sum){
		
		if(root == null)
			return false;
		
		
		if(root.data == element){
			total = total + root.data;
			System.out.print(root.data + " ");
			return true;
		}
		
		if(IsSumAvailable(root.left, element, sum) || IsSumAvailable(root.right, element, sum)){
			total = total + root.data;
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
