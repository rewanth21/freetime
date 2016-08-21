package Trees;

public class ArrayToTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Integer[] array = {3, 6, 8, 23, 48, 76, 89 };
        
        
        Node treeRoot = Balance(array);
        BalanceTree(array, 0, array.length-1);
        inorder(treeRoot);
        
	}

	
	static void inorder(Node root){
		if(root != null){
			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}
	}
	
	  static Node Balance(Integer[] array) {
			
			        return BalanceTree(array, 0, array.length-1);
		    }
			
		
	static Node BalanceTree(Integer[] array, int start, int end){
		
	if(array == null || array.length == 0 || start > end){
			return null;
		}
		
		int mid = (start+end)/2;
		
		Node root = new Node(array[mid]);
		
		root.left = BalanceTree(array, start, mid-1);
		root.right = BalanceTree(array, mid+1, end);
	
		
		return root;
	}
	
}
