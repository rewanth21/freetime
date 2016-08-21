package Trees;

public class SearchElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int element = 2;
       Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
SearchElement m = new SearchElement();
System.out.println("Element is there? : " + m.findElement(root, element));			
	}
		
	boolean findElement(Node root, int element){
		if(root!=null){
		
			if(root.data == element){
			return true;
		}
		else  
			return findElement(root.left, element) || findElement(root.right, element);
	}
	
	return false;
}
	
	
	
	
	
}