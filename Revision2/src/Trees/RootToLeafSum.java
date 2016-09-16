package Trees;

public class RootToLeafSum {

	
	static Node root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 root = new Node(3);
	       root.left = new Node(1);
	   root.right = new Node(5);
	 root.left.left = new Node(0);
	   root.left.right = new Node(2);
	    root.right.left = new Node(4);
	      root.right.right = new Node(6);
	    root.right.right.right = new Node(7);
	       root.right.right.right.right = new Node(10);
	       
	       
	}

}
