package Trees;

public class MaxInBinaryTree {

	public int getMax(Node root) {
		Node current = root;
		
		if(root == null){
			System.out.println("empty tree");
			return -1;
		}
		
		
		
		while(current.right != null){
			current = current.right;
		}
		
		return current.data;
	}
	
	
	
///////////////using recursion////////////////
	/*
public int getMax(Node root) {
Node current = root;

if(root == null){
	System.out.println("empty tree");
	return -1;
}



if(current.right == null){
	return current.data;
}

return getMax(current.right);
}
*/
///////////////using recursion////////////////	
	public static void main(String[] args) {
		Node root = new Node(10);		
				root.left = new Node(20);
				root.right = new Node(30);
				root.right.right= new Node(12);
		MaxInBinaryTree m = new MaxInBinaryTree();
		System.out.println("Max element in Binary Tree: " + m.getMax(root));			
			}
		}

		class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
		this.data = data;
			}
		}
