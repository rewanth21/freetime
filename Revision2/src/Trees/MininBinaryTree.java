package Trees;

public class MininBinaryTree {

	
	///////////////using iterative////////////////
	/*public int getMin(Node root) {
		Node current = root;
		
		if(root == null){
			System.out.println("empty tree");
			return -1;
		}
		
		
		
		while(current.left != null){
			current = current.left;
		}
		
		return current.data;
	}*/
///////////////using iterative////////////////
	
///////////////using recursion////////////////
	public int getMin(Node root) {
		Node current = root;
		
		if(root == null){
			System.out.println("empty tree");
			return -1;
		}
		
		
		
		if(current.left == null){
			return current.data;
		}
		
		return getMin(current.left);
	}
///////////////using recursion////////////////	
	
		public static void main(String[] args) {
		Node root = new Node(10);		
				root.left = new Node(5);
				root.right = new Node(30);
				root.right.right= new Node(12);
		MininBinaryTree m = new MininBinaryTree();
		System.out.println("Max element in Binary Tree: " + m.getMin(root));			
			}
		}
		
		
