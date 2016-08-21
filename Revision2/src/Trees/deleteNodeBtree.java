package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class deleteNodeBtree {

	static Node deepestnode;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
				
				Node deep = deepestNode(root);
				System.out.println();
				System.out.println(deep.data);
				
				
				
				levelOrder(delete(root, deep, 3));
				
	}
	
	static void levelOrder(Node root){
		if(root == null){
			return;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node current = queue.poll();
			System.out.print(current.data + " ");
			if(current.left != null){
				queue.add(current.left);
			}
			if(current.right != null){
				queue.add(current.right);
			}
		}
	}
	
	static Node delete(Node root, Node deep, int data){
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			if(queue.peek().data == data){
				queue.peek().data = deep.data;
				
			}
			
			Node current = queue.poll();
			
			if(current.left != null){
				queue.add(current.left);
			}
			if(current.right != null){
				queue.add(current.right);
			}
		}
		return root;
	}
	
	
	
	static Node deepestNode(Node root){
		if (root == null){
			return root;
		}
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			deepestnode = queue.peek();
			Node current = queue.poll();
			System.out.print(current.data);
			if(current.left != null){
				queue.add(current.left);
			}
			if(current.right!= null){
				queue.add(current.right);
			}
		}
		return deepestnode;
	}
	

	
	

}
