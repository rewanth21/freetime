package Trees;

public class BinaryTreeBalanced {

	static Node root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 BinaryTreeBalanced tree = new BinaryTreeBalanced();
		
		   tree.root = new Node(3);
	       tree.root.left = new Node(1);
	       tree.root.right = new Node(5);
	       tree.root.left.left = new Node(0);
	       tree.root.left.right = new Node(2);
	       tree.root.right.left = new Node(4);
	       tree.root.right.right = new Node(6);
	       tree.root.right.right.right = new Node(7);
	       tree.root.right.right.right.right = new Node(10);
	       
	       int leftTree = findLeftRight(root.left);
	       int rightTree = findLeftRight(root.right);
	       
	       
	       if(Math.abs(rightTree) - Math.abs(leftTree)  <= 1){
	  		 System.out.println("binary tree is balanced");
	  	 }
	       else
	    	   System.out.println("binary tree is not balanced");
	       
	}
		
	static int findLeftRight(Node root){
		
		if(root == null){
			return -1;
		}
		
		return Math.max(findLeftRight(root.left), findLeftRight(root.right)) + 1;
		
}
	
/*	static int findRight(Node root){
		
		if(root == null){
			return -1;
		}
		
		return Math.max(findRight(root.left), findRight(root.right)) + 1;
		
	}
	*/
	
	 

}
