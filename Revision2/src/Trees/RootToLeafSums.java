package Trees;

import java.util.Stack;

public class RootToLeafSums {

	static Node root;
	static Stack<Integer> stack = new Stack<>();
	static int total = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(7);
        
        int sum = 14;
        getAllLeaves(root);
        while(!stack.isEmpty()){
        	PathWithSum(root, stack.pop(), sum);
        	System.out.println(total);
        	total = 0;
        }
       
        
	}
	
	static boolean PathWithSum(Node root, int element, int sum){
		
		if(root == null)
			return false;
		
		if(root.data == element){
			total = total + root.data;
			System.out.print(root.data + " ");
			return true;
		}
				
		if(PathWithSum(root.left, element, total) || PathWithSum(root.right, element, total)){
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
