package Trees;

public class PrintOuterEdges {

	public static void main(String[] args) {
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
	
        
        
        printleftwitmainroot(root);
        printright(root);
	}
	
	static void printleftwitmainroot(Node root){
		if(root == null){
			return;
		}
		
		
		printleftwitmainroot(root.left);
		System.out.println(root.data);
		
	}
	
	static void printright(Node root){
		while(root.right !=null){
			
			root = root.right;
			System.out.println(root.data);
		}
	}

}
