package Trees;

public class PrintOnlyOneSiblingTree {

	
	 static Node root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
		
		
		printWithOneSibling(root);
		
	}
	
	static void printWithOneSibling(Node root){
		if(root == null){
			return;
		}
		
		   
			        if (root.left == null && root.right != null)
			        {
			            System.out.println(root.right.data);
			        }
			        if (root.right == null && root.left != null)
			        {
			            System.out.println(root.left.data);
			        }
		
		
		 printWithOneSibling(root.left);
		 printWithOneSibling(root.right);
		
	}

}
