package Trees;

public class SumOfLeftNodes {

	
	 static int counter = 0;
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
		root.left.left.right = new Node(8);
		root.left.left.right.left = new Node(9);
		
		int[] leftLeavesSum = new int[1];
		
		findLeftLeavesSum(root);
		System.out.println(counter);
	}
	
	  static void findLeftLeavesSum(Node root){
		
		 if(root == null){
			 return;
		 }
		  
		  
		if(isLeftNode(root.left)){
			counter = counter + root.left.data;
		}
		
		 findLeftLeavesSum(root.left);
		findLeftLeavesSum(root.right);
		
		
	}

	  
	  static boolean isLeftNode(Node root){
		  if(root == null)
			  return false;
		  
		  if(root.left == null && root.right == null){
			  return true;
		  }
		  
			  return false;
	  }
	  
	
	  
	  
	
	
	
}
