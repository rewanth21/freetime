package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BSearchTreeToLL {

	static Node root;
	static LinkedList<Node> linkedlist = new LinkedList<Node>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(13);
		root.left.left = new Node(6);
		root.left.right = new Node(9);
		root.right.left = new Node(11);
		root.right.right = new Node(15);
		root.right.right.right = new Node(17);
		root.right.right.right.left = new Node(14);
		 
		convertToLL(root);
		
		for(Node node : linkedlist){
			System.out.print(node.data + " ");
		}
		
		
		
	}
	
	static void convertToLL(Node root){
		if(root == null){
			System.out.println("No linked list since bbtree is null");
		}
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		
		linkedlist.add(root);
		
		while(!queue.isEmpty()){
			Node current = queue.poll();
			System.out.print(current.data + " ");
			if(current.left != null){
				linkedlist.add(current.left);
				queue.add(current.left);
			}
			if(current.right != null){
				linkedlist.add(current.right);
				queue.add(current.right);
				
			}
		}
		System.out.println();
	}
	
	

}
