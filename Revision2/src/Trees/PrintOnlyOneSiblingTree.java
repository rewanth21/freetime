package Trees;

public class PrintOnlyOneSiblingTree {

	
	 static Node root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintOnlyOneSiblingTree PST = new PrintOnlyOneSiblingTree();
		// TODO Auto-generated method stub
		PST.root = new Node(1);
		PST.root.left = new Node(2);
		PST.root.right = new Node(3);
		PST.root.left.left = new Node(4);
		PST.root.left.right = new Node(5);
		PST.root.right.left = new Node(6);
		PST.root.right.right = new Node(7);
		PST.root.right.right.right = new Node(8);
		PST.root.right.right.right.left = new Node(10);
		
		
		PST.printWithOneSibling(root);
		
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
