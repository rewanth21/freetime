package Trees;

public class LeafNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		//root.left.left = new Node(4);
		//root.left.right = new Node(5);
		//root.right.left = new Node(6);
		root.right.right = new Node(16);
		//root.right.right.right = new Node(8);
		//root.right.right.right.left = new Node(10);

		findAllLeafNodes(root);



	}

	static void findAllLeafNodes(Node root){
		if(root == null)
		{
			return;
		}


		if(root.left == null && root.right == null){
			System.out.println(root.data);
		}
		
		findAllLeafNodes(root.left);
		findAllLeafNodes(root.right);
		

	}
}
