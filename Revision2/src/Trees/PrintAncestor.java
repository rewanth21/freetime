package Trees;

import java.util.Stack;

public class PrintAncestor {
static Node root;
static Stack<Node> stack = new Stack<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrintAncestor m = new PrintAncestor();	
        int element = 5;
        m.root = new Node(1);
        m.root.left = new Node(2);
        m.root.right = new Node(3);
        m.root.left.left = new Node(4);
        m.root.left.right = new Node(5);
        m.root.left.left.left = new Node(7);
 
			
		   m.ancestor(root, 5);
		   System.out.println();
		   while(!stack.isEmpty()){
			   System.out.print(stack.pop().data + " ");
		   }
		    
	}
	
	
	boolean ancestor(Node root, int element){
		
		
		if(root == null){
			return false;
			
		}
		
		if(root.data == element){
			//stack.push(root);
			//System.out.println(root.data);
			return true;
		}
		
		if(ancestor(root.left, element) || 
				ancestor(root.right, element)){
			stack.push(root);
			System.out.println(root.data);
			return true;
		}
	return false;
		
		
		/*while(root !=null){
			
			if(root.data == element){
				
				for(int i : ancestors){
					System.out.print(i);
				}
				return;
			}
			
			if(root.data < element){
				root = root.left;
				ancestors.push(root.data);
			}
			else if (root.data > element){
				root = root.right;
				ancestors.push(root.data);
			}
		}*/
		
		
		
		
		
	}
	

}
