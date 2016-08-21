package Trees;

public class deleteNode {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(12);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(3);
		root.left.right = new Node(7);
		root.right.left = new Node(13);
		root.right.right = new Node(17);
		root.left.left.left = new Node(1);
		root.left.left.right = new Node(9);
		
		
		root = Delete(root,15);
		
		
		InOrder(root);
	}
	
	static void InOrder(Node root){
		if (root !=null){
			System.out.println(root.data);
			InOrder(root.left);
			
			
			InOrder(root.right);
		}
	}
	public static Node Delete(Node root, int data){
		
		
		if(root == null)
			return root;
		else if(data < root.data){
			 root.left = Delete(root.left, data);
		}
		else if(data > root.data){
			 root.right = Delete(root.right, data);
		}
		else
		{
			if(root.left == null && root.right == null){
				root = null;
				
			}
			else if(root.right == null){
				Node temp = root;
				root = root.right;
				temp = null;
			}
			else if(root.left == null){
				Node temp = root;
				root = root.left;
				temp = null;
			}
			//case 3 : 2 children 
			else{
				Node temp = FindMin(root.right);
				root.data = temp.data;
				root.right = Delete(root.right,temp.data);
			}
				
		}
		
		
		return root;
	}
	
	public static Node FindMin(Node root){
		while(root.left != null){
			root = root.left;
		}
		return root;
	}
	
	

}
