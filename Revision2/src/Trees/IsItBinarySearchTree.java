package Trees;

public class IsItBinarySearchTree {
static Node root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 IsItBinarySearchTree tree = new IsItBinarySearchTree();
			
		   tree.root = new Node(7);
	       tree.root.left = new Node(4);
	       tree.root.right = new Node(9);
	       tree.root.left.left = new Node(1);
	       tree.root.left.right = new Node(6);
	      // tree.root.right.left = new Node(4);
	      // tree.root.right.left.right = new Node(6);
	       
	       
	      // int maxValue = getMax(root);
	     //  int minValue = getMin(root);
	       
	       //System.out.println(getMin(root));
	     //  System.out.println(getMax(root));
	       
	       //System.out.println(IsBst(root, -1, 12));
	       
	       System.out.println(IsBinarySearchTree(root));
	       
	}
	
	
	/*static boolean IsBst(Node root, int minValue, int maxValue){
		if(root == null)
			return true;
		
		
		if(root.data > minValue && root.data < maxValue
				&& IsBst(root.left, minValue, root.data)
				&& IsBst(root.right, root.data, maxValue)){
			return true;
		}
			else 
				return false;
					
		
		
		
	}

	static int getMin(Node root){
		
		if(root.left == null){
			return root.data;
		}
		
		return getMin(root.left);
	}
	
	static int getMax(Node root){
		if(root.right == null){
			return root.data;
		}
		return getMax(root.right);
	}*/
	
	
	static boolean IsSubtreeLesser(Node root, int value){
		if(root == null)
			return true;
		
		if(root.data <= value &&
				IsSubtreeLesser(root.left, value) &&
				IsSubtreeLesser(root.right, value)){
			return true;
		}
		else return false;
			
		
	}
	
	static boolean IsSubtreeGreater(Node root, int value){
		if(root == null)
			return true;
		
		if(root.data >= value &&
				IsSubtreeGreater(root.left, value) &&
				IsSubtreeGreater(root.right, value)){
			return true;
		}
		else return false;
    
	}
    static boolean IsBinarySearchTree(Node root){
    	
    	if(root == null){
    		return true;
    	}
    	
    	if(IsSubtreeLesser(root.left, root.data) &&
    	IsSubtreeGreater(root.right, root.data) &&
    	IsBinarySearchTree(root.left) && 
    	IsBinarySearchTree(root.right))
    		return true;
    	else
    		return false;
    		
    }
	
	
}
