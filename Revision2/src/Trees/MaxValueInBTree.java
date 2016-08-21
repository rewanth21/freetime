package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaxValueInBTree {
	static int maxval = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(0);
		root.left = new Node(1);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.left.left.right = new Node(6);
		root.left.left.right.right = new Node(8);
		root.right.left = new Node(5);
		root.right.left.right = new Node(7);
		root.right.left.right.right = new Node(9);
		
	   findMax(root);
		maxvalrecurse(root);
		System.out.println(maxval);
	}
	
	static void  maxvalrecurse(Node root){
		if(root == null){
			return;
		}
		if(root.data > maxval){
			maxval = root.data;
		}
		
		maxvalrecurse(root.left);
		maxvalrecurse(root.right);
	}
	
	
	
	static void findMax(Node root){
		
		
		if(root == null){
			return;
		}
		
		Queue<Node> queue = new LinkedList<>();
		ArrayList<Node> list = new ArrayList<>();
		
		
		queue.add(root);
		list.add(root);
		int max = root.data;
		while(!queue.isEmpty()){
			
			Node current = queue.poll();
			System.out.print(current.data + " ");
			
			if(current.left != null){
				queue.add(current.left);
				if(current.left.data > max){
					max = current.left.data;
				}
				
			}
			if(current.right != null){
				queue.add(current.right);
				if(current.right.data > max){
					max = current.right.data;
				}
				
			}
			
			
		}
		
		System.out.println();
		
		System.out.println(max);
		
	}
	

}
